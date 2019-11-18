<template>
<b-navbar toggleable="lg" type="dark" variant="info" >
    
    <b-navbar-brand href="#/homepage">TutorME</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item-dropdown text="Lesson">
        <b-dropdown-item href="#/lesson">View Lessons</b-dropdown-item>
        <b-dropdown-item href="#/createlesson">Create Lesson</b-dropdown-item></b-nav-item-dropdown>
        <b-nav-item-dropdown text="Course">
        <b-dropdown-item href="#/course">View Courses</b-dropdown-item>
        <b-dropdown-item href="#/createsubject">Create Subject</b-dropdown-item></b-nav-item-dropdown>
         <b-nav-item-dropdown text="University">
        <b-dropdown-item href="#/university">View Universities</b-dropdown-item>
        <b-dropdown-item href="#/createuniversity">Create Universities</b-dropdown-item></b-nav-item-dropdown>
         <b-nav-item-dropdown text="Room">
        <b-dropdown-item href="#/room">View Rooms</b-dropdown-item>
        <b-dropdown-item href="#/createroom">Create Room</b-dropdown-item></b-nav-item-dropdown>
        <b-nav-item href="#/student">Student</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#/tutor">Tutor</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
      

        <b-nav-item-dropdown right>
        <template v-slot:button-content>
        <em>User</em>
        </template>
        <b-dropdown-item href="/welcome">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  </template>


  