<template>
  <div>
    <br />
    <br />
    <span class="title">All Lessons</span>
    <hr />
    <center>
      <template v-if="hasLessons">
        <div class="mainForm">
          <b-list-group-item
            href="#"
            class="flex-column align-items-start"
            v-for="(lesson,idx) in lessons"
            :key="idx"
          >
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">Lesson ID: {{lesson.lessonId}}</h5>
            </div>

            <p class="mb-1">
              <!-- This lesson is taught by {{lesson.tutor.name||"Tutor"}} for {{lesson.subject.subject_name||"Subject"}} + 
              {{lesson.course.courseName||"Course"}} at {{lesson.university.university_name||"University"}}.-->
              This lesson goes from {{lesson.startTime}} to {{lesson.endTime}}
            </p>
            <b-list-group-item
            href="#"
            class="flex-column align-items-start"
            v-for="(student, email) in students"
            :key="email"
            >
            <small class="text-muted">Click to update the lesson.</small>
          </b-list-group-item>
          <br />
          <br />
        </div>
      </template>
      <template v-else>
        <div>Uh-oh, there are no lessons to display!</div>
      </template>
    </center>
  </div>
</template>

<script src='../javascript/lesson.js'/>

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