# Router

## Day 021 - 2026-04-01

---

## 목차

1. vue-router 1
2. vue-router 2
3. vue-router 3

---

## vue-router 1

### Vue Router 기본

#### Vue Router란?

- 화면마다 고유의 식별자(URL)를 기반으로 화면을 렌더링
- router 이용한 폴더구조

```txt
src/
├── main.js
├── App.vue
├── router/
│   └── index.js
├── pages/
│   ├── HomeView.vue
│   └── AboutView.vue
├── components/
│   ├── NavBar.vue
│   └── MyButton.vue
```

#### `createRouter()`

- router 객체 생성

```js
// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'home', component: HomeView },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),
    },
  ],
});

const app = createApp(App);
app.use(router);
```

> [!TIP]
> **Lazy Loading** (첫 화면만 먼저 빠르게 로딩)
>
> ```js
> // 1. Lazy Loading — 해당 페이지 이동 시 로드 (빌드 파일도 별도 분리)
> component: () => import('../views/AboutView.vue');
>
> // 2. 즉시 로딩 — 앱 시작 시 전부 로드 (하나의 파일로 빌드)
> component: AboutView;
> ```
>
> 실무에서는 1번 방식 사용

#### `RouterView`

- 각 컴포넌트를 렌더링할 위치를 지정하는 컴포넌트
- `RouterLink` 대신 `router-link` 케밥케이스로도 사용 가능

```vue
<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <header>
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink :to="{ name: 'about' }">About</RouterLink>
    </nav>
  </header>
  <RouterView />
</template>
```

> [!WARNING]
> SPA에서 `<a href="">`
> href에 `#`이 아닌 내부 경로가 오면 SPA가 깨짐
> 외부 사이트 링크는 `<a>` 사용 가능 (`target="_blank"`로 새 탭 권장)

---

## vue-router 2

### 동적 라우트 (Dynamic Route)

- 일정 패턴의 URL 경로를 하나의 라우트에 연결하는 방법
- URL의 일부를 변수로 받는 것 (예: 유저 상세 페이지)

```js
// router/index.js
const router = createRouter({
  routes: [{ path: '/members/:id', component: MemberInfo }],
});
```

```vue
<script setup>
import { useRoute } from 'vue-router';

const currentRoute = useRoute();
</script>

<template>
  경로 패턴: /members/:id <br />
  id 값: {{ currentRoute.params.id }} <br />
</template>
```

> [!TIP]
> script에서 id를 숫자로 사용할 때 형변환 필요
> `parseInt(currentRoute.params.id)`

### 중첩 라우트

- 화면 전환 없이 라우트를 중첩시켜 보이도록 함
- 개념 정도만 알고 넘어가기

### 명명된 라우트 (Named Route)

- 라우트 정보에 이름을 부여해 path 대신 name으로 라우팅
- **path보다 권장** — URL은 변경될 수 있지만 name은 고정

```vue
<!-- 선언적 방식 -->
<RouterLink :to="{ name: 'members', params: { id: 1 } }">멤버</RouterLink>
```

```js
// 프로그래밍 방식
router.push({ name: 'members', params: { id: 1 } });
```

### 명명된 뷰 (Named View)

- 이름이 지정되지 않은 뷰 → 기본 뷰 (default)

---

## vue-router 3

### 라우터 객체의 메서드

### `push`

히스토리 스택에 추가 (뒤로가기 가능)

```js
router.push('/about'); // path
router.push({ name: 'members', params: { id: 1 } }); // 명명된 라우트
router.push({ path: '/board', query: { pageno: 1 } }); // 쿼리 문자열
```

### 네비게이션 가드 (Navigation Guard)

- 라우팅을 보호하는 기능 (예: 로그인한 사용자만 접근 가능한 페이지)
- 개념만 알고 가기

---

## 기억할 것

- `route` — 현재 경로 정보 (params, query, name 등)
- `router` — 경로 이동 함수 (push, replace 등)
- 서버 API가 준비되지 않았을 경우 → `member.json` 같은 로컬 json 파일로 대체
