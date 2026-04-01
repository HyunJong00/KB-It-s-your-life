import ElectronicsPage from '@/pages/ElectronicsPage.vue';
import HomePage from '@/pages/HomePage.vue';
import JeweleryPage from '@/pages/JeweleryPage.vue';
import MensClothingPage from '@/pages/MensClothingPage.vue';
import WomensClothingPage from '@/pages/WomensClothingPage.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', name: 'home', component: HomePage },
    { path: '/electronics', name: 'eletronics', component: ElectronicsPage },
    { path: '/jewelery', name: 'jewelery', component: JeweleryPage },
    {
      path: '/mensclothing',
      name: "men's clothing",
      component: MensClothingPage,
    },
    {
      path: '/womensclothing',
      name: "/women's clothing",
      component: WomensClothingPage,
    },
  ],
});

export default router;
