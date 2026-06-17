# JOIN

## Day 052 - 2026-05-27

---

## 목차

1. MySQL 내장함수
2. JOIN(조인)

## MySQL 내장함수

### 제어 흐름 함수

#### IF(수식,참,거짓)

- SELECT IC (100>200,'참이다','거짓이다')
- 삼항 연산자 처럼 사용됨

#### IFNULL(수식1, 수식2) ( 오라클에서는 NVL)

- 수식 1이 NULL이 아니면 수식1 반환
- 수식 1이 NULL이면 수식2 반환

#### NULLIF(수식1, 수식2)

- 수식1과 수식2가 같으면 NULL 반환
- 수식1과 수식2가 다르면 수식1 반환

#### CASE ~ WHEN ~ ELSE ~ END

### 문자열 함수

#### CONCAT(문자열1, 문자열2, ...)

- CONCAT(): 문자열을 이어줌
- CONCAT_WS(): 구분자와 함께 문자열 이어줌
- CONCAT_WS(구분자, 문자열1, 문자열2, ...)

#### UPPER(), LOWER()

- 소문자를 대문자로, 대문자를 소문자로

#### REPLACE(문자열, 원래문자열, 바꿀 문자열)

- 문자열에서 원래문자열을 찾아서 바꿀 문자열로 바꿈
- SELECT REPLACE('이것이 MySQL이다', '이것이', 'This is')

#### INSERT(기준 문자열, 위치, 길이, 삽입할 문자열)

- 기준문자열의 위치부터 길이만큼 지우고 삽입할 문자열 끼워넣음
- SELECT INSERT('abcdefghi',3,4,'@@@@')
  - 'ab@@@@ghi' 반환
  - 인덱스는 항상 1부터 시작

#### SUBSTRING(문자열, 시작위치, 길이)

- 시작위치부터 길이만큼 문자를 반환
- 길이 생략시 문자열 끝까지 반환
- SELECT SUBSTRING('대한민국만세',3,2)
  - '민국'

### 수학, 날짜 함수

#### CEILING(숫자), FLOOR(숫자), ROUND(숫자)

- 올림, 내림, 반올림

#### CURDATE(), CURTIME(), NOW(), SYSDATE()

- CURDATE : 현재 연-월-일
- CURTIME : 현재 시 : 분 : 초
- NOW, SYSDATE : 현재 '연-월-일 시:분:초'

#### DATE(), TIME()

- DATETIME 형식에서 연-월-일 및 시:분:초만 추출

## JOIN(조인)

### INNER JOIN(내부조인)

- 일반적으로 JOIN이라고 얘기하는 조인으로 JOIN만 써도 INNER JOIN 인식됨
- 업무에서 가장 많이 쓰이는 조인

```SQL
SELECT <열목록>
FROM <첫 번째 테이블>
INNER JOIN <두 번째 테이블>
    ON <조인될 조건>
[WHERE 검색조건]

SELECT *
FROM buytbl
INNER JOIN usertbl
    ON buytbl.userID = usertbl.userID
WHERE buytbl.userID = 'JYP';
```

### OUTER JOIN(외부조인)

```SQL
SELECT <열목록>
FROM <첫 번째 테이블(LEFT 테이블)>
<LEFT | RIGHT | FULL(mysql에 없음)> OUTER JOIN <두 번째 테이블(RIGHT 테이블)>
    ON <조인될 조건>
[WHERE 검색조건]

SELECT U.userID, U.name, B.prodName, U.addr,
    CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
    LEFT OUTER JOIN buytbl B
        ON U.userID = B.userID
ORDER BY U.userID;
```

### 3개 테이블 조인

- 다대다(N:M) 관계에서 주로 사용
- 두번(이상)의 조인을 통한 추출
- 연결 테이블을 중간에 조인
  - ex. 학생 join 학생 동아리 join 동아리

```SQL
-- 학생을 기준으로 학생이름/지역/가입한동아리/동아리방 정보 추출
SELECT S.stdName, S.addr, SC.clubName, C.roomNo
FROM stdtbl S
    INNER JOIN stdclubtbl SC
        ON S.stdName = SC.stdName
    INNER JOIN clubtbl C
        ON SC.clubName = C.clubName
ORDER BY S.stdName;

-- 동아리를 기준으로 가입한 학생의 목록 추출
SELECT C.clubName, C.roomNo, S.stdName, S.addr
FROM stdtbl S
    INNER JOIN stdclubtbl SC
        ON SC.stdName = S.stdName
    INNER JOIN clubtbl C
        ON SC.clubName = C.clubName
ORDER BY C.clubName;
```

### SELF JOIN(자체 조인)

- 자기 자신과 자기 자신이 조인한다는 의미

```SQL
SELECT A.emp AS '부하직원', B.emp AS '직속상관', B.empTel AS '직속상관연락처'
FROM empTbl A
    INNER JOIN empTbl B
        ON A.manager = B.emp
WHERE A.emp = '우대리';
```

### UNION / UNION ALL / NOT IN / IN

- 두 쿼리의 결과를 행으로 합치는 것
- 컬럼의 개수, 타입 같으면 가능(암묵적 형변환 가능한 경우도 가능)
- 공지사항 + 일반 게시판 만들때 사용 할 수 있음

```SQL
SELECT 문장1 ( 공지사항, LIMIT 5)
    UNION[ALL]
SELECT 문장2 ( 일반 게시판)
```
