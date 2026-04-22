# designPattern
## Day 030 - 2026-04-21

---
## 목차
1. SOLID
2. Template Method
3. 중첩 선언과 익명 객체
## 디자인 패턴
### SOLID
1. 단일 책임 원칙 (Single Responsibility Principle: SRP)
### 단일 책임 원칙 (Single Responsibility Principle: SRP)
- 클래스는 단 하나의 책임 -> 클래스를 변경하는 이유는 한 개여야 함

### 개방 폐쇄 원칙 (Open-Closed Principle: OCP)
- 기능확장에는 열려있고, 변화에는 닫혀 있어야 함
- 추상화와 다형성(상속)을 이용해 구현

### 리스코프 치환 원칙 (Liskov Substitution Principle: LSP)
- 상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상 동잭 해야 한다.
- 개방 폐쇄 원칙을 받쳐 주는 다형성에 관한 원칙 제공

### 인터페이스 분리 원칙(Interface Segregation Principle: ISP)
- 클라이언트는 자신이 사용하는 메서드에 의존해야 한다 
- -> 인터페이스는 그 인터페이스를 사용하는 클라이언트를 기준으로 분리해야 한다

### 의존 역전 원칙 (Dependency Inversion Principle: DIP)
- 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안된다
- 추상 클래스 또는 인터페이스를 통해 약 결합
- **약결합** (Aggregation) : 교체 가능하게 설계(부모 타입으로 운영) : 1. 생성자 주입 2. setter 이용
- 강결합 (Composition) : 콘크리트 클래스(추상타입을 구체회한 클래스로 굳은 클래스 의미), new 객체

## Template Method
### 템플릿 메서드 패턴
- 템플릿 기능을 가진 패턴
- 상위 클래스 쪽에서 템플릿이 될 메소드로 정의 (추상 메서드)
- -> 상위 클래스에서 처리의 뼈대를 결정하고 하위 클래스에서 그 구체적인 내용을 결정하는 디자인 패턴
- **사용 이유**
- 로직을 공통화할 수 있다
- -> 프레임워크의 기본 패턴

## 중첩 선언과 익명 객체
### 중첩 클래스
- 멤버 클래스 : 클래스의 멤버로서 선언되는 중첩 클래스
- 로컬 클래스 : 메소드 내부에서 선언되는 중첩 클래스
- `내부 클래스 외부에서 선언시 Outer.Inner inner = outer.new Inner()`
```java
class Outer {
    private int a;
    class Inner{
        private int b;
        //Outer의 a를 private 이지만 마음대로 사용 가능함
        //getter, setter도 필요 없음
        // Outer가 Inner의 b는 Inner 객체 선언(new)로 선언하여 접근 
    }
}
```

### 정적 중첩 클래스 — Builder 패턴

```java
public class UserDto {
    private String name;

    public static class Builder {
        public Builder name(String name) {  }
        public UserDto build() {  }
    }
}

UserDto user = new UserDto.Builder().name("홍길동").build();
```

### 내부 클래스 — outer 멤버 접근

```java
class Button {
    private String label = "클릭";

    class ClickListener {
        void onClick() {
            System.out.println(label); // outer 멤버 직접 접근
        }
    }
}
```

### 익명 클래스 vs 람다
- `new 클래스명(){}` or `new 인터페이스명(){}`
```java
// 메서드 1개 → 람다 권장
Runnable r = () -> System.out.println("실행");

// 메서드 2개 이상 → 익명 클래스
Comparator<String> c = new Comparator<>() {
    public int compare(String a, String b) { return a.compareTo(b); }
    public String toString() { return "comparator"; }
};
```

## 인터페이스
- 추상메서드와 상수만 존재했으나 static 가능해짐 -> 유틸리티를 응집시키기 위함
- default 메서드 사용시 오버리이딩 필요 없음. 나머지는 오버라이딩 필수

## 정리
- **SRP** 가장 중요함
- SOLID를 다른 말로 **Programming to Interface**
- 위 원칙을 통해 코드 리뷰할 수 있으며 리팩토링 할 수도 있음
- SRP가 되어 있느냐에 따라 초보자 구분 가능 ( + 가독성 )

### 내부, 익명(요즘은 람다) 클래스
- 안드로이드에서 많이 사용
- 백엔드에선 거의 사용 없음
### 개념만
- 내일 배울 스레드는 개념만 알면 됨
- 인터페이스 등장으로 추상클래스 죽어가는 중
### 면접 단골
- 오버로드, 오버라이드
- AutoBoxing(기본형->래퍼), unboxing(래퍼->기본형)
- 멀티 캐스팅, 멀티스레드
### 더 공부할 것

- [ ] 인터페이스

### 기억할 내용
>[!important] 
> - Outer Inner 의 멤버 시용은 시험 단골