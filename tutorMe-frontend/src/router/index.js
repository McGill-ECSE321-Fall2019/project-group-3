import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/components/Welcome'
import Registration from '@/components/Registration'
import Students from '@/components/Students'
import Tutors from '@/components/Tutors'
import Course from '@/components/Course/Course'
import University from '@/components/University/University'
import CreateUniversity from '@/components/University/CreateUniversity'
import CreateLesson from '@/components/Lesson/CreateLesson'
import CreateCourse from '@/components/Course/CreateCourse'
import CreateSubject from '@/components/Course/CreateSubject'
import Homepage from '@/components/Homepage'
import Room from '@/components/Room/Room';
import CreateRoom from '@/components/Room/CreateRoom'
import Lesson from '@/components/Lesson/Lesson';


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
      path: '/CreateCourse', 
      name: 'CreateCourse', 
      component: CreateCourse
    },
    {
      path: '/CreateSubject', 
      name: 'CreateSubject', 
      component: CreateSubject
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
    },
    {
      path: '/createroom',
      name: 'CreateRoom',
      component: CreateRoom
    },
    {
      path: '/CreateUniversity',
      name: 'CreateUniversity',
      component: CreateUniversity
    },
    {
      path: '/CreateLesson', 
      name: 'CreateLesson', 
      component: CreateLesson
    }
  ]
})
