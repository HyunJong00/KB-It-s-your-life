# try-catch
## Day 031 - 2026-04-22

---
## 목차
1. 예외 처리
2. Object

## 예외 처리
- 생성자 내부와 메소드 내부에서 작성
- 컴파일
  - `try-catch-finally`
  - `throws` : 백신, 자바에게 에러를 던져 에러를 잡는 역할
  - `throw` : 바이러스, 에러를 발생시키는 역할
- 실행 - 큰 문제 없음. IDE가 해줌 + 개발자가 할 일

## Object
- 자바의 최상위, 최초의 클래스
- 모든 클래스가 Object 상속
- 10개의 메소드 중 String 의 override
  - toString() : 클래스@16진수
    - String클래스가 Object 상속받아 toString()오버라이딩 : 문자열
  - equals() : 참조값 비교
    - String클래스에서는 문자열 비교
  - hashCode(): 주소를 10진수
    - String에서는 믿을수 없음. 문자열은 무한대이므로 10진수 표현 다 못함
### Class 클래스

- 클래스 자체에 대한 정보를 담고 있는 클래스
- 클래스의 구조 (이름, 필드, 메서드, ...)를 담고 있는 설계도의 설계도
- `Class<Person>` : 클래스의 분석 도구라고 보면 됨
#### class 클래스 생성 방법
1. 클래스 리터럴 사용
   - `Class<String> clazz = String.class;`
2. 인스턴스에서 얻기
   - `String str = "hello";`
   - `Class<String> clazz = str.getClass()`
3. **동적 로딩** ( 가장 많이 사용 )
   - `Class<?> clazz = Class.forName("java.lang.String")`
   - ? class 로 모든 클래스 수용
   - 매개변수로 풀쿼리 작성 필요
#### 리플렉션 (Reflection)
- 프로그램이 실행 중에 자기 자신이나 다른 객체의 내부 구조를 검사하고 수정하는 기법이다.
- 실행 중에 클래스 정보를 분석하고, 객체를 만들고, 값을 바꾸고, 메서드를 실행하는 기술이다.
## 정리

### 더 공부할 것

- [ ] Spring 의 AOP ( 관점 지향) : invoke

### 기억할 내용
