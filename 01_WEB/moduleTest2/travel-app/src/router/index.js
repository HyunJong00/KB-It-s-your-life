import { createRouter, createWebHistory } from 'vue-router';

import HomePage from '../pages/HomePage.vue';
import TravelListPage from '@/pages/TravelListPage.vue';
import TravelDetailPage from '@/pages/TravelDetailPage.vue';
import TravelWritePage from '@/pages/TravelWritePage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', name: 'home', component: HomePage },
    { path: '/travel/list', component: TravelListPage },
    {
      path: '/travel/view/:id',
      name: 'travel/view',
      component: TravelDetailPage,
    },
    { path: '/travel/write', component: TravelWritePage },
    // 문제 1-1.	라우터 테이블을 완성하세요.
    // 답안을 작성 후, 해당 컴포넌트가 존재하지 않아 실행되지 않을 수 있습니다.
    // 주석으로 막아 처리한 후
    // 해당 컴포넌트가 만들어지면 주석을 풀어 라우터 설정을 적용하세요.
  ],
});

export default router;
