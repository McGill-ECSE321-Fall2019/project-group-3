import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Lesson from '@/components/Lesson'
import Welcome from '@/components/Welcome'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    }, 
    {
      path: '/lesson', 
      name: 'Lesson', 
      component: Lesson
    }, 
    {
      path: '/welcome',
      name: 'Welcome', 
      component: Welcome
    }
  ]
})
