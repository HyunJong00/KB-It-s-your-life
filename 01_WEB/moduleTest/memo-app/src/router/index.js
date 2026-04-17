import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/pages/HomePage.vue';
import MemoListPage from '@/pages/MemoListPage.vue';
import MemoWritePage from '@/pages/MemoWritePage.vue';
import MemoDetailPage from '@/pages/MemoDetailPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', component: HomePage },
    // 문제 1.	라우터 테이블을 완성하세요.
    // 답안을 작성 후, 해당 컴포넌트가 존재하지 않아 실행되지 않을 수 있습니다.
    // 주석으로 막아 처리한 후
    // 해당 컴포넌트가 만들어지면 주석을 풀어 라우터 설정을 적용하세요.
    //
    { path: '/memo', component: MemoListPage },
    { path: '/memo/view/:id', name: 'memo/id', component: MemoDetailPage },
    { path: '/memo/write', component: MemoWritePage },
  ],
});

export default router;
