import AboutView from '@/pages/About.vue';
import HomeView from '@/pages/Home.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'home', component: HomeView },
    { path: '/about', name: 'about', component: AboutView },
    { path: '/members', name: 'members', component: Members },
    { path: '/videos', name: 'videos', component: Videos },
  ],
});
export default router;
