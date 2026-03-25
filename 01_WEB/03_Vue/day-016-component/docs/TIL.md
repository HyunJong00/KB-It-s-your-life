# component

## Day 016 - 2026-03-25

---

## 목차

1. 컴포넌트 스타일
2. 슬롯

## 단일 파일 컴포넌트 스타일

- 전역 CSS
  - src/main.js에서 import 한 css로 전체 페이지에 적용
- 범위 CSS (컴포넌트 단위)
  - import 순서에 따라 CSS 정의 됨
  - scoped 사용 시 컴포넌트 안에서만 적용 되며 자식에게도 적용 X
  - style module(react의 css모듈) 사용 가능하나 주로 scoped 이용

## 슬롯

- 슬롯: props 처럼 부모가 자식에게 템플릿 정보를 전달하는 방법(Layout)
- 부모가 채울수 있는 자식의 빈 영역
- 자식은 슬롯 위치만 지정 `<slot>Item</slot>` : react의 {{props.children}}
- 부모는 컴포넌트 사이에 내용 입력

- 명명된 슬롯 : 여러 slot 사용할 경우
- 자식은 `<slot name="슬롯명"></slot>`, 이름이 없는 경우는 default
- 부모는 `<... v-slot:슬롯명></>`
- 축약형: `#`

- 범위 슬롯(scoped slot): 심화과정
- 자식의 데이터를 부모에게 넘겨주며 부모가 직접 렌더링 할때 사용
- 자식은 `<slot :item="item" />`
- 부모는 ` <span>{{ item.name }}</span>`

## JS의 클래스

### 더 공부할 것

- [ ] Class의 Prototype

### 기억할 내용

- v-if는 연속해서 사용 해야함
- 데이터를 찾을때는 find, 수정, 제거할때는 findindex
- cdn은 main.css에 작성, main.js에서 import
