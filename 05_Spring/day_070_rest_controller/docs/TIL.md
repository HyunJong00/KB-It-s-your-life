# REST Controller

## Day 070 - 2026-06-23

---

## 목차

## mybatis

### applicationContext.xml

- mybatis를 쓰는 가장 큰 이유 :
  - java와 sql을 분리하기 위함(종속되지 않도록)

- Connection Pool에는 DataSource만 접근 가능함
- Connection Pool로 hikari사용
- hikary : 은행 / dataSource: 은행 창구 직원

#### hikary

- applicationContext.xml: `<bean id="hikariconfig" class="com.zaxxer.hikari.HikariConfig"></bean>`
- `HikariConfig hikariconfig = new Hikariconfig()`
  - 위 두줄은 같은 결과임
- `<property name="driverClassName" value="${jdbc.driver}"/>`
- `<property name="jdbcUrl" value="${jdbc.url}"/>`
- HikariConfig 클래스의 set 메서드를 호출하는 방식임
- setDriverClassname(), setJdbcUrl()과 같음

#### dataSource

- `<constructor-arg ref="hikariConfig"/>`
- constructor-arg : 생성자 호출

#### SqlSession / SqlSessionFactory

### mybatis-config.xml

- 환경설정 파일(DTD) 생성해야 하며 절대 손으로 쓰지 말고 복붙할 것

### (user)mapper.xml (SQL)

- 여러개의 mapper파일이 존재함
- 스프링은 여러개의 mapper를 한번에 읽음
- `id`는 매버파일에 유일해야 함
  - mapper namespace를 사용하므로 충돌 방지(id중복 가능)
  - ex. namespace="userSQL"

## Rest 컨트롤러

### RestController

#### @RestController

- 모든 메서드에 `@ResponseBody` 적용
- 응답 타입은 application/json

#### @RequestBody

- application/json으로 인코딩된 요청을 DTO로 매핑

### 응답

#### ResponseEntyty<T>

- 빌더 패턴

```java
ResponseEntity.ok.build(); // 200 코드만 구성
ResponseEntity.ok(body); // 200 + body
ResponseEntity.status(상태코드).build(); // 상태코드만 구성(ex.201)

```

#### RestControllerAdvice

- 예외처리 될 경우 advice로 처리
- Advice의 경우 예외를 핸들링 해 view에 전달 : rest에 맞지 않음
  - `@RestControllerAdvice` : `ResponseEntity<T> 구성 후 리턴

### Swagger

| 어노테이션                         | 설명                                      |
| ---------------------------------- | ----------------------------------------- |
| `@ApiAperation()`                  | api 메서드 설명(value, notes)             |
| `@ApiResponses({@ApiResponse,...}) | api 응답 설명(code, message, response)    |
| `@ApiParam`                        | api 파라미터 설명(value,required,example) |
| `@ApiModel`                        | DTO 모델 클래스 설명(description)         |
| `@ApiModelProperty`                | DTO 필드(프로퍼티) 설명 (value, example)  |

## 정리
