import { createRouter, createWebHistory } from 'vue-router'
import DiaryList from '@/views/DiaryList.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: DiaryList,
    },
    {
      path: '/write',
      name: 'write',
      component: () => import('@/views/DiaryWrite.vue'),
    },
    {
      path: '/detail/:id',
      name: 'detail',
      component: () => import('@/views/DiaryDetail.vue'),
      props: true,
    },
    {
      path: '/edit/:id',
      name: 'edit',
      component: () => import('@/views/DiaryEdit.vue'),
      props: true,
    },
  ],
})

export default router
