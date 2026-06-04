# MongoDB

## Day 057 - 2026-06-04

---

## 목차

## MongoDB 소개

### MongoDB 특징

- 높은 읽기/쓰기 효율
- 직관적 데이터
  - 행(row) 대신 도큐먼트(document)에 저장
  - 도큐먼트 : 속성의 이름과 값으로 이루어진 쌍의 집합
- 고정된 스키마 없음
  - DB가 아닌 어플리케이션이 데이터 구조를 결정
  - 데이터 구조가 빈번히 변경되는 개발 초기에 개발 속도를 단축
  - 가변 속성 표현 가능(추후에 필요한 필드 걱정 안해도 됨)
- 컬렉션(collection)에 도큐먼트 저장(RDBS의 테이블)

### MongoDB의 도큐먼트 형식

- 임의의 구조를 저장하는 스키마
- JSON 기반
- key, value로 구서어, 중첩제한 없음
- 객체지향 언어의 객체에 잘 매핑됨 (JS에 최적화)

### MongoDB 기능

#### 확장

- 수평 확장(sharding)에 용이하다
  - sharding : 범위 기반 파티션 메커니즘으로 여러 노드에 분산하는 것
  - 데이터를 여러 서버에 분산 저장
  - 대용량 트래픽에 강함
- 수직적 확장(하나의 서버 성능을 향상시키는 것)

#### 복제(replica set)

- 자동 장애 복구 지원(장애 발생시 세컨더리 노드(복제 db) 이용한 안정적 운영 가능)
- 고가용성 보장

#### 인덱스

- 다양한 인덱스 지원
  - B-Tree기반
  - \_id 프라이머리케에 자동 인덱스

## 쿼리

### select

- `db.posts.find({ tag: 'politics', vote_count: { $gt: 10 }});`
- `findOne()`, `find()`

### AND, OR

- `~.find({$and:[age:10,username:"smith"]})`
- `~.find({$or:[username:"jones",username:"smith"]})`

### update

- `db.users.update({username:"smith"}, {$set:{country:"Canada"}})`
  - $set : 부분 선택
  - $unset:{키:1} (문서 형식을 취해야 함으로 1 을 대입)
- 전체 문서 변경시 `replaceOne`
- 세 번째 파라미터 : 해당 문서 없는 경우 insert 여부(default : false)
- 네 번째 파라미터 : 다중업데이트 여부(default: false)
- 배열에 요소 추가
  - `$push` : 배열에 무조건 추가, 중복 가능
  - `addToSet` : 중복 없이 배열에 추가

### delete

- `db.users.remove({"favorites.cities":"Cheyenne"})
- `db.users.deleteMany({})`
- `db.user.drop()` : 컬렉션 삭제
