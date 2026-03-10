# JavaScript 기본문법

## Day 005 - 2026-03-10

---

## 목차

1. 용어

## 용어

- 표현식: 값을 만들어 내는 코드
- 문장: 실행의 최소 단위로 `;` or 줄바꿈으로 구분
- 식별자: 변수나 함수의 이름을 붙일때 사용하는 단어
- 리터럴(literal): 직접 쓴 고정 값(코드에 글자 그대로 적힌 값)
  - 숫자 리터럴 : 10, 3.14, 0xFA
  - 문자 리터럴 : '2' 'a'
  - 문자열 리터럴 : "hello"
-

> [!TIP]
>
> 1. 클래스 외 생성자 함수 이름은 항상 **대문자**
> 2. 변수, 인스턴스, 함수, 메서드의 이름은 항상 **소문자**
> 3. 여러 단어로 된 식별자는 각 단어의 첫 글자를 **대문자**
> 4. 문자열의 경우 작은따옴표 권장 '' (hmtl의 값과 혼동 방지)
> 5. `var`은 요즘은 사용 안함
>
> - 케밥 표기법
>   - a-b-c 주로 html, css에서 사용
> - 스네이크
>   - a_b_c 주로 파스칼, css
> - 낙타
>   - myApple
>   - java, javascript
> - 파스칼
>   - MyApple
>   - 객체(클래스)명

> ![NOTE]
> 컴파일 언어는 정수/정수 = 정수(소숫점 버림)
> 스크립트 언어는 정수/정수 = 실수(소수도 표현)

### 반복문

- for(let i in array): key 값 사용(index 등)
- for(let i of array): value 값 사용

### 함수

- 익명 함수: function(){}
- 선언적 함수: function 함수() {}
- js는 에러를 거의 안냄

```javascript
function f(x) {
  return x * x;
}
alert(f(3, 4)); // 첫 매개변수만 적용됨
alert(f()); // return undefind
```

- 콜백 함수: 매개변수로 전달되는 함수

```js
function callTenTimes(callback) {
  for (let i = 0; i < 10; i++) {
    callback();
  }
}

//선언적 함수: 가독성 좋음
let fun = function () {
  alert('함수 호출');
};
callTenTimes(fun);

//비선언적(권장): closer의 장점이 생김
callTenTimes(function () {
  alert('함수 호출');
});
```

### 객체

- 속성(property)
- 메서드(method)
- this
  - 객체 밖에서 사용할 경우 window객체가 됨

```js
let object = {
  number: 12,
  string: 'h',
  array: [12, 41],
  method: function () {},
};
```

## 추가 학습

### defer

- defer는 `<script>` 태그에 붙이는 속성으로, HTML을 먼저 끝까지 읽은 뒤(파싱 완료 후) JavaScript를 실행하라는 의미이다.
- 요즘 대세
- `<script src="app.js" defer></script>`

### 비교연산자

- '10' == 10 -> true
- '10' === 10 -> false

### false

- false
- 0
- ''
- null
- undefinded
- NaN (Not a Number)

> [!warning] [ ] 빈 배열은 JS에서는 true이지만, Python에서는 false 이다.

### &&, ||

√ JS에서 && 연산

- JS의 &&는 boolean이 아니라 피연산자 값을 반환한다.
- 왼쪽부터 검사해서 첫 번째 falsy 값이 나오면 그 값을 반환
- 모두 truthy라면 마지막 값을 반환
- `console.log(false && "Hello");`
  - hello

√ JS에서 || 연산

- JS의 ||는 boolean이 아니라 피연산자 값을 반환한다.
- 왼쪽부터 검사해서 첫 번째 truthy 값을 반환
- 모두 falsy이면 마지막 값을 반환
- `console.log(0 || "" || "First Truthy" || "Second Truthy");`
  - First Truty

## 정리

### 더 공부할 것

- [ ]

### 기억할 내용

```

```

```

```

```

```
