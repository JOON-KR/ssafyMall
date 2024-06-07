import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ItemView from '@/views/ItemView.vue'
import SearchView from '@/views/SearchView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/item/:itemNm',
      name: 'item',
      component: ItemView
    },
    {
      path: '/search/:keyword',
      name: 'search',
      component: SearchView
    }
  ]
})

export default router
