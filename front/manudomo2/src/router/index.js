import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Profil from '@/components/Profil'
import MonitoringPage from '@/components/MonitoringPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/profil',
      name: 'Profil',
      component: Profil
    },
    {
      path: '/monitoring',
      name: 'Monitoring',
      component: MonitoringPage
    }
  ]
})
