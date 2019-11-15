<template>
  <div>
    <br />
    <br />
    <span class="title">All Courses</span>
    <router-link to="CreateCourse">
      <b-button pill variant="success" class="addButton">+</b-button>
    </router-link>
    <hr />
    <center>
      <template v-if="hasCourses">
        <div class="mainForm">
          <b-list-group-item
            href="#"
            class="flex-column align-items-start"
            v-for="(course,idx) in courses"
            :key="idx"
          >
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">Course Name: {{course.courseName}}</h5>
              <b-button
                v-on:click="deleteCourse(course.courseName)"
                pill
                variant="outline-danger"
              >Delete</b-button>
            </div>
            <small class="text-muted">Click to update the course.</small>
          </b-list-group-item>
          <br />
          <br />
        </div>
      </template>
      <template v-else>
        <div>Uh-oh, there are no courses to display!</div>
      </template>
    </center>
  </div>
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
</style>