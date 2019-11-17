<template>
<b-navbar toggleable="lg" type="dark" variant="info" >
    
    <b-navbar-brand href="#/homepage">TutorME</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#/lesson">Lesson</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#/course">Course</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#/university">University</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#/room">Room</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#">Group Lesson Requests</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#/student">Student</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#/tutor">Tutor</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
		    <b-nav-item href="#/payroll">Payroll</b-nav-item>
        <b-nav-item href="#" enabled></b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        

        <b-nav-item-dropdown text="Lang" right>
          <b-dropdown-item href="#">EN</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template v-slot:button-content>
            <em>User</em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#welcome">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  </template>


  