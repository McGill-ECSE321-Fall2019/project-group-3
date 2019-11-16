<!-- <template>
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
</template> -->

<template>
  <center>
    <div role="tablist">
      <template v-if="hasSubjects">
        <div class="mainForm">
          <b-list-group-item
            href="#"
            class="flex-column align-items-start"
            v-for="(subject, idx) in subjects"
            :key="idx"
          >
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">Subject Name: {{subject.subject_name}}</h5>
              <b-button
                v-on:click="deleteSubject(subject.subject_name)"
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
      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block href="#" v-b-toggle.accordion-1 variant="info">Accordion 1</b-button>
        </b-card-header>
        <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>I start opened because <code>visible</code> is <code>true</code></b-card-text>
            <b-card-text>blas</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>

      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block href="#" v-b-toggle.accordion-2 variant="info">Accordion 2</b-button>
        </b-card-header>
        <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>bla</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>

      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block href="#" v-b-toggle.accordion-3 variant="info">Accordion 3</b-button>
        </b-card-header>
        <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>bla</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
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
</style>