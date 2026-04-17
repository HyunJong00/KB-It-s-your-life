# class
## Day 027 - 2026-04-16

---
## 목차
1. java-basic

## 1. java-basic
### 가변 배열
### 향상된 for문
- `for(int score: scores){}`
- python에 `for i in array:` 같은 느낌인듯
### Enum
## 2. Class
### this
- 현재 인스턴스에 대한 참조 변수
- 자동 생성 됨
- this.변수명으로 필드 변수에 접근
- 생성자에서 this로 다른 생성자 호출하여 코드 중복 방지
```java
Car(String model,String color, int maxSpeed){
    this.model = model;
    this.color = color;
    this.maxSqeed = maxSpeed;
}

Car(String model){
    this(model,"은색",250);
    // 위의 생성자를 호출
}
```
### 메소드
- 가변길이 매개변수
  - `int sum(int ... values){}`
- return: 메소드 실행을 강제 종료후 호출한 곳으로 돌아감
### 멤버
| 구분           | 설명          |
|--------------|-------------|
| 인스턴스 멤버      | 객체에 소속된 멤버  |
| 정적(static)멤버 | 클래스에 고정된 멤버 |

- 정적 멤버
  - 메소드 영역의 클래스에 고정적으로 위치하는 멤버
  - 클래스이름 + 도트(.) 연산자로 접근 가능
  - 객체 참조 변수로도 접근 가능(비권장)
  - 정적 메소드와 정적 블록은 내부에 인스턴스 필드나 인스턴스 메소드, this 사용 불가
### final
- 초기화 이후 readOnly
- 상수 처럼 사용하나 인스턴스 별로 존재
- `static final` 사용함으로 상수가 됨(method area에 생성됨)
- 상수는 대문자+언더바(_) 사용이 관례
## 정리

### 더 공부할 것

- [ ]

### 기억할 내용
> [!Warning]
> - 추상화(설계) 잘 못함 -> 클래스 정의 많이 해봐라 하심
> - 다 뽑아진 설계도로 개발은 잘함