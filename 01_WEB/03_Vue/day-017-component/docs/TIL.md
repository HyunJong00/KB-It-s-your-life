# component

## Day 017 - 2026-03-26

---

## 목차

1. 동적 컴포넌트

## 동적 컴포넌트

- 같은 위치에 여러 컴포넌트를 사용하는 방법
- `<component :is="">`
- :is 다음 오는 컴포넌트를 보여줌

```javascript
:class="{active:tab.id === currentTab}"
<component :is"currentTab"/>
```

### 사용자 정의 v-model

- `update: modelValue`
- update를 사용하므로써 자동으로 업데이트 ( 함수를 따로 만들 필요가 없음, v-modeld의 규칙)
- defineModel()이라는 간편화 방식(vue3)도 있어서 추후 배울 예정

### provide,injection

- 공용데이터를 부모컴포넌트에서 제공(provide)
- 아무 하위 컴포넌트에 필요한 데이터 주입(injection)
- react에 contextAPI와 같은 개념
- props drilling 해결하기 위함
- 단방향으로 데이터 수정은 안됨

```VUE
export default{
    data(){
        return {
            user: {name: '홍길동',age:20}
        }
    },
    provide{
        return{
            user: this.user
        }
    }
}
```

```VUE
export default {
  inject: ['user']  // 중간 컴포넌트 건너뛰고 바로 받음
}
```

### 텔레포트 Teleport(필요할때 찾아쓰는 요소)

### 비동기 컴포넌트(빈도 낮음)

- `import {defineAsyncComponent} from 'vue'
const AsyncComponent = defineAsyncComponent(()=> import('./AsyncComponent.vue')
)`
- proxy처럼 감싸서 사용하는 것

## JS 객체

### 상속

- closure (클로저) 이용해 접근제한할 수 있음(원래 스크립트 언어는 모든게 public)
- function Square(length){
  this.base = Rectangle;
  this.base(length,length)
  //Rectangle(length,length)로 호출한다면 new 없으므로 this가 Square의 인스턴스가 됨(_무슨말이지_)
  }
- `extens`, `super`키워드 도입

```js
class Parent {
  constructor(name) {
    this.name = name;
  }
  print() {
    console.log('이름: ' + this.name);
  }
}

class Child extends Parent {
  constructor(name, age) {
    super(name); // 부모의 생성자는 반드시 호출
    this.age = age;
  }
  print() {
    super.print();
    console.log('나이 : ' + this.age);
  }
  static sayHello() {
    console.log('Hello~');
  }
}
```

- 데이터 -> 인스턴스 멤버로 운영(권장)
- 함수(메서드) -> prototype 멤버로 운영(공유정보)(권장)
- prototpye 멤버로 데이터 배정한다면? (공유데이터가 되므로 접근하는 인스턴스마다 다른값이 될 수 있음)
  - prototpye 으로 데이터 사용하려면 읽기 전용으로 사용 가능

### Getter/Setter

- get,set으로 사용된는 변수를 property 라고 함

```js
class Student {
  constructor(name, age) {
    this._name = name;
    this.age = age;
  }
  get name() {
    return this._name; // 내부에 _name으로 저장해 프로퍼티 알기 어렵게 함. 바깥에서는 name으로 사용
  }
}
```

## 추가 학습

### 더 공부할 것

- [ ] 동적컴포넌트에서 keep-alive, active:
- [ ] Vue3에서의 computed
- [ ] 텔레포트

### 기억할 내용

- 화살표 함수와 일반함수의 this 확실히 개념 잡기
- 화살표 함수는 정의된 위치에서의 this (setTimeout 은 무조건 화살표)
- 일반함수는 호출된 위치에서 this
