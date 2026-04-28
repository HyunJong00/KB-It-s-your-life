# collection
## Day 035 - 2026-04-28

---
## 목차
1. Iterator
2. Collection
## Iterator
- 처리를 반복하는 방법
- 향상된 for문
  - `for(int i: arr) {}`
  - arr는 Iterator 정의된 객체만 가능
- 어떤 컬랙션을 사용하던 똑같이 반복문 사용할 수 있음
  - 구현과 분리하여 반복 가능
  
## Collection
### TreeSet, TreeMap
- 검색 기능을 강화시킨 컬랙션
- 작은값은 왼쪽, 큰 값은 오른쪽에 저장
  - 비교 가능한 객체만 가능
- 데이터가 정렬되서 들어가야 함(TreeMap) -> 코테에서만 쓰이며 실무에서는 사용 안함
#### TreeSet
- 이진 트리를 기반으로 한 Set
- `first()`, `last()`, `lower(E e)`: left, `higher()`:right
#### TreeMap
- TreeSet, TreeMap 이런게 있다만 알아도 된다 하심 ㅎ

### Comparable, Comparator
- TreeSet, TreeMap에 저장되는 키 객체 정렬
- `list.sort(new Comparator<Fruit>() {}` : list 정렬 가능
- Comparable 인터페이스에는 compareTo()메소드 재정의(같으면 0, 작으면 -, 크면 +)
- 비교 기능이 없는 Comparable 비구현 객체를 저장하려면 비교자 Comparator 제공
- compare() 메소드를 재정의

### LIFO,FIFO
#### Stack : LIFO
#### Queue : FIFO
- LinkedList로 사용하면 됨

### 동기화된 컬렉션
- Collections의 synchronizedXXX() 메서드:
  - Arraylist, HashSet, HashMap 등 비동기화 된 메소드를 동기화된 매소드로 래핑(일종의 proxy)
  - `synchronizedList(List<T> list)`
- 여러 멀티스레드 환경에서 안전하게 사용 할 수 있음

## 추가
### 동기화, Command 패턴 - 여러 요청에 대한 처리 기법
- 요청을 map으로 매핑시켜서 분리 -> switch 대신 한가지 호출문으로 통일
- 활용 예시
  - 작업 큐 (스레드풀, 메시지 큐)
  - Undo/Redo (텍스트 에디터, 포토샵)
  - 매크로 (여러 커맨드 묶음 실행)
  - 트랜잭션 (DB 작업 롤백)
```java
    // 한번의 호출로 처리 가능하도록 할 수 있음
    messageQueue.offer(new Message("sendMail", "hong"));
    messageQueue.offer(new Message("sendSMS", "park"));
    messageQueue.offer(new Message("sendKaKaoTalk", "kim"));

    /*  
    멀티 스레드를 이용해 개별 스레드로 작업할 수 있게 할 수 있음
    인터페이스 정의 + ExecutorService 사용하면 됨
    spring에서는 @Async 사용하면 됨
    */
        
    while(!messageQueue.isEmpty()) {
    Message message = messageQueue.poll();
        switch(message.command()){
            case "sendMail":
                System.out.println(message.to() + "님에게 메일을 보냅니다");
                break;
            case "sendSMS":
                System.out.println(message.to() + "님에게 SMS를 보냅니다.");
                break;
            case "sendKaKaoTalk":
                System.out.println(message.to() + "님에게 카카오톡을 보냅니다.");
                break;
        }
    }
```

### Command - 명령을 클래스로 표현하다
- switch case의 분기로 나누는 호출 코드에 적용하기 좋음
  - 호출을 분리하지 않고 한번에 사용 -> OCP 원칙
- 호출 코드의 공통점 ( 매개변수, 리턴 등 )을 찾기
#### Command 클래스
- '명령'을 표현하는 클래스
- `메소드 호출`이라는 동적인 처리로 표현하지 않고, 클래스의 인스턴스라는 하나의 '객체'로 표현
- 공통부분의 인터페이스, 각 명령 구현의 클래스로 구현
- 실행부에서 배열을 통해 클래스.메서드 로 명령 실행
### AutoBoxing, AutoUnBoxing(UnAutoBoxing)
- 기본형을 Wrapper class로 포장하는 것. 기본형으로 포장 제거하는 것 
- boolean <-> Boolean
- int <-> Integer

## 정리

### 더 공부할 것

- [ ] 

### 기억할 내용
- 서버 코드 개발 뿐 아니라, 구조와 SOLID 원칙을 통한 코드 리뷰 능력 키우기
- 동기 방법을 이용한 서버사이드의 성능 향상 및 구조 개선 방법 알기 (Spring은 자동으로 해줌)