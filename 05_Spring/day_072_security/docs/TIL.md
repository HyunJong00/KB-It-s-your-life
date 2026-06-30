# security

## Day 072 - 2026-06-25

---

## 목차

1. 스프링 복습

## 스프링 복습

오늘은 JWT에 대해 배웠지만 지금까지의 흐름을 복습하여 정리하고자 한다.

### 설정파일(config)

| 설정 파일         | 대체하는 XML        | 역할                                        |
| ----------------- | ------------------- | ------------------------------------------- |
| **WebConfig**     | web.xml             | 애플리케이션 시작점, DispatcherServlet 등록 |
| **RootConfig**    | root-context.xml    | 비즈니스 계층(웹과 독립적인 부분) 빈 등록   |
| **ServletConfig** | servlet-context.xml | 웹 계층(HTTP 요청 처리) 빈 등록             |

### RootConfig

#### HikaryCP

- 커넥션 풀의 한 종류로 `DataSource`의 구현체
- `HikariConfig`에 연결정보를 저장
- `HikaryDataSource(hicariConfig)` 생성

#### MyBatis

- 기존의 SQL을 그대로 활용할 수 있음
- `mybatis-spring`이라는 라이브러리로 연동

SQLSessionFactory

- MyBatis의 가장 핵심 객체
- SqlSession을 만드는 존재
- `SQLSessionFactoryBean` 객체를 통해 DataSource, Mapper 정보 저장

Mapepr

| 구분        | XML 방식         | Interface + Annotation 방식 |
| ----------- | ---------------- | --------------------------- |
| SQL 위치    | 별도 XML 파일    | 인터페이스에 직접 작성      |
| 적합한 쿼리 | 복잡한 동적 쿼리 | 단순 CRUD                   |
| 가독성      | 길어도 편함      | 짧을 때만 깔끔              |

## 스프링 시큐리티

### CROSS ORIGIN

- origin : 서버의 주소, port
- 기본적으로 브라우저는 모든 서버 통신을 허용하지 않음
- 성공적으로 서버통신 되도 브라우저가 실패를 반환함 (기본값)
- 서버는 CROSS ORIGIN을 허용 해야함

### API 서버를 위한 기본 설정

```java
http.httpBasic().disable()  // 기본 HTTP 인증 비활성화
    .csrf().disable()       // CSRF 비활성화
    .formLogin().disable()  // formLogin 관련 필터 해제
    .sessionManagement().sessionCreationPolicy(
        SessionCreationPolicy.STATELESS);
```

### JWT(Json Web Token)

#### JWT 구조

- Header
  - 서명 알고리즘 제시
- Payload
  - claim : JWT Payload 안에 담기는 key-value 쌍 하나하나
- Signature
  - 탈취 되더라도 변조 불가능 하도록 역할
  - 솔트??

#### JWT 운영

- AcessToken
  - 짧은 유효시간(몇 분)
- Refresh Token
  - 긴 유효시간(몇 일)
- 클라이언트
  - 쿠키나 스토리지에 토큰 저장
  - API 요청시 헤더에 Acess Token 담아서 요청

- Access Token 만료시 RT로 AT 재발급
- RT 만료시 강제 로그아웃

### jjwt 라이브러리

자바를 위한 jwt 라이브러리

- 토큰 생성 기능(로그인, 연장 시)
- subject 추출 기능(토큰 통한 유저정보 확인)
- claim에 추가정보 설정 기능

#### 토큰 주요 오류

- 토큰 만기
- 서명 오류
- 문자열 불일치(깨짐)

## 정리

### 더 공부할 것

- [ ]

### 기억할 내용

```

```
