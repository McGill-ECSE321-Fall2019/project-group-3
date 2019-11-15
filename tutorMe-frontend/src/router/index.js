import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/components/Welcome'
import University from '@/components/University'
import Registration from '@/components/Registration'
import Homepage from '@/components/Homepage'
import Room from '@/components/Room';


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome
    }, 
    {
      path: '/lesson', 
      name: 'Lesson', 
      component: Lesson
    }, 
    {
      path: '/course', 
      name: 'Course', 
      component: Course
    }, 
    {
      path: '/university', 
      name: 'University', 
      component: University
    },
    {
      path: '/registration',
      name: 'Registration',
      component: Registration
    },
    {
    path: '/homepage',
    name: 'Homepage',
    component: Homepage
    },
    {
    path: '/room',
    name: 'Room',
    component: Room
    }

  ]
})
