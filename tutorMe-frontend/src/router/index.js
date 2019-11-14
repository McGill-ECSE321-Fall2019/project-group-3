import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Lesson from '@/components/Lesson/Lesson'
import Welcome from '@/components/Welcome'
import Registration from '@/components/Registration'
import Students from '@/components/Students'
import Tutors from '@/components/Tutors'
import Homepage from '@/components/Homepage'
import Course from '@/components/Course/Course'
import University from '@/components/University/University'
import CreateLesson from '@/components/Lesson/CreateLesson'
import Homepage from '@/components/Homepage'
import Room from '@/components/Room';


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
    }, {
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
      path: '/tutors',
      name: 'Tutors',
      component: Tutors
    },
     {
      path: '/students',
      name: 'Students',
      component: Students
    },
    {
      path: '/registration',
      name: 'Registration',
      component: Registration
<<<<<<< HEAD
    }, 
    {
      path: '/CreateLesson', 
      name: 'CreateLesson', 
      component: CreateLesson
=======
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
>>>>>>> 5ca990ad3d3446a313a7d5cad7f8733c31071bb5
    }

  ]
})
