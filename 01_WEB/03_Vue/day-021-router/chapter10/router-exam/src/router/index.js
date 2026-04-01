import Home from '@/pages/Home.vue';
import PostDetail from '@/pages/PostDetail.vue';
import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
  },
  { path: '/post/:id', name: 'post', component: PostDetail },
];
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
