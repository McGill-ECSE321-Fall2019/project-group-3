<template>

  <center>
    <NavBar/>
    <br>
    <br>
    <router-link to="Createsubject">
      <b-button pill variant="info" class="addSubjectButton">Create Subject</b-button>
    </router-link>
    <span class = "title"><b><font size="+3">All Courses</font></b></span>
    <hr />
    <div class = "mainForm">
      <b-card-group deck v-for="(subject, idx) in subjects"
      :key="idx">
      <b-card>
        <template v-slot:header>
          <h5 class="mb-1"><b>Subject Name: {{subject.subject_name}}</b> </h5>
          <br>
          <router-link to="CreateCourse">
      <b-button pill variant="outline-info" class="addButton">Create Course</b-button>
    </router-link>
          <b-button
            class = "deleteButton"
            v-on:click="deleteSubject(subject.subject_name)"
            pill
            variant="outline-danger"
          >Delete Subject</b-button>
        </template>
        <b-list-group>
          <b-list-group-item href="#" class="flex-column align-items-start" v-for="(course , course_idx) in subject.courses" :key="course_idx">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1"><b>Course Name: {{course.courseName}}</b> </h5>
            </div>
            <b-button
                class = "deleteButton"
                v-on:click="deleteCourse(course.courseName)"
                pill
                variant="outline-danger"
              >Delete Course</b-button>

            <p class="mb-1">
              Course information. 
            </p>

          </b-list-group-item>
        </b-list-group>
      </b-card>
    </b-card-group>



  </div>
</center>
</template>

<script src='../javascript/course.js'/>

<style scoped>
  .mainForm {
    width: 80%;
  }
  .title {
    flex: 1;
    text-align: center;
  }
  .addButton {
    flex: 1;
    float: right;
    margin-left: 25%;
    margin-right: 25%;
  }
  .addSubjectButton {
    flex: 1;
    float: right;
    margin-left: 25%;
    margin-right: 25%;
  }
</style>

