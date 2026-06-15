# bean

## Day 064 - 2026-06-15

---

## 목차

## 스프링이란

JAVA ENTERPRISE APPLICATIN 개발에 사용되는 자바 플랫폼을 위한 오픈소스 어플리케이션 프레임워크

- 특징
  - 자바 객체를 담고 있는 경량 컨테이너이다
  - 객체의 생성, 소멸과 같은 라이프 사이클을 스프링이 관리
  - **스프링으로부터 필요한 객체를 얻어 올 수 있다**
- POJO(Plain Old Java Object) : 특별한 규칙이나 프레임워크에 종속되지 않은 순수한 자바 객체(상속 없는)
  - Mybatis에서 xml로 sql 작성하여 java에 종속 되지 않도록 하는 것(config.xml, Mapper.xml)
- IOC -Inversion of Control(제어 반전) : 컨트롤 제어권을 사용자에서 스프링으로 역전된 것
- DI - Dependency Injection (의존성 주입)
- AOP - Aspect Oriented Programming

- 스프링 컨테이너 = BeanFactory(기본 공장)
  - 객체(Bean) 생성
  - 스프링에서는 객체를 Bean으로 부름

- 스프링 컨텍스트 = ApplicationContext(종합환경)
  - 컨테이너보다 큰 개념이나 같은말로 혼용됨

### 스프링 설정

- xml, 어노테이션 함께 사용하는 것을 추천하심
- build.gradle
  - mvn 에서 spring 검색시 가장 먼저 나오는 spring-context implements

## 빈 생성 방법

1. `@Component` : 클래스 위에 사용
2. `@Bean` : 메서드 위에 사용 (메서드에서 리턴하는 값을 Bean으로 생성)

```java
    @Bean // 메서드 명은 반드시 Bean의 이름(객체명) 이어야 한다.
          // 그렇지 않은 경우 `@Bean(name="helloService") 사용하면 됨
    public HelloService helloService(){
        return new HelloService();
    }
```

## 정리

[1] 컨테이너 생성
ApplicationContext 시작, 빈 컨테이너 준비

[2] Bean 정의 읽기 ← @ComponentScan, @Component
스캔 → BeanDefinition(설계도) 생성 → Registry에 등록
(아직 객체 없음)

[3] Bean 인스턴스 생성
설계도 기반으로 생성자 호출 → 빈 껍데기 객체 생성

[4] 의존성 주입 (DI) ← @Autowired
필요한 다른 Bean을 객체에 주입

[5] 초기화 콜백
@PostConstruct 등 실행, (필요 시) AOP 프록시 생성

[6] 사용 가능 → Context에 보관
싱글톤 캐시에 저장, 애플리케이션에서 꺼내 사용
... 종료 시 소멸 콜백 실행
