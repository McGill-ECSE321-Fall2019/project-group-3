<template>
  <div>
    <NavBar/>
    <br />
    <br />
    <router-link to="CreateLesson">
      <b-button pill variant="info" class="addButton">Create Lesson</b-button>
    </router-link>
    <span class = "title"><center><b><font size="+3">All Lessons</font></b></center></span>
    <hr />
    <center>

      <template v-if="lessons != null && lessons != undefined && lessons.length!=null">
        <div class="mainForm">

          <b-card v-if="privateLessons.length!=0">
              <div align = "left">
                <b-card-title> Private Lessons</b-card-title>
              </div>

              <b-list-group-item
              href="#"
              class="flex-column align-items-start"
              v-for="(lesson,idx) in privateLessons"
              :key="idx"
              >
              <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1"><b>Lesson ID: {{lesson.lessonId}}</b></h5>
                <b-button
                v-on:click="deleteLesson(lesson.lessonId)"
                pill
                variant="outline-danger"
                >Delete</b-button>

              </div>

              <p class="mb-1" v-if="lesson.startTime != null && lesson.endTime != null">
                <b-container class="bv-example-row">
                  <b-row >
                    <b-col> <h5 class="mb-1"> <img src="@/assets/date.png" width="35" height="40"><b><font size="+1.5"> Date</font></b></h5>{{"\n" + lesson.startTime.substr(0,10)}}</b-col>
                    <b-col><h5 class="mb-1"> <img src="@/assets/time.png" width="60" height="30"><b><font size="+1.5">  Time</font></b></h5>{{"\n" + lesson.startTime.substr(11,19)+"-"+lesson.endTime.substr(11,19)}}</b-col>
                  </b-row>
                </b-container>
              </p>

              <small class="text-muted" v-on:click="updateLesson(lesson.lessonId)">Click here to update the lesson.</small>
            </b-list-group-item>
            <br />
            <br />
        </b-card>

        <b-card v-if="groupLessons.length!=0">
          <div align = "left">
            <b-card-title> Group Lessons</b-card-title>
            <b-card-sub-title> <i>(lessons with more than 7 students)  </i></b-card-sub-title>
          </div>

          <b-list-group-item
          href="#"
          class="flex-column align-items-start"
          v-for="(lesson,idx) in groupLessons"
          :key="idx"
          >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1"><b>Lesson ID: {{lesson.lessonId}}</b></h5>
            <b-button
            v-on:click="deleteLesson(lesson.lessonId)"
            pill
            variant="outline-danger"
            >Delete</b-button>

          </div>

          <p class="mb-1">
            <b-container class="bv-example-row" v-if="lesson.startTime != null && lesson.endTime != null">
              <b-row>
                <b-col> <h5 class="mb-1"> <img src="@/assets/date.png" width="35" height="40"><b><font size="+1.5"> Date</font></b></h5>{{"\n" + lesson.startTime.substr(0,10)}}</b-col>
                <b-col><h5 class="mb-1"> <img src="@/assets/time.png" width="60" height="30"><b><font size="+1.5">  Time</font></b></h5>{{"\n" + lesson.startTime.substr(11,19)+"-"+lesson.endTime.substr(11,19)}}</b-col>
              </b-row>
            </b-container>
          </p>

          <small class="text-muted" v-on:click="updateLesson(lesson.lessonId)">Click here to update the lesson.</small>
        </b-list-group-item>
        <br />
        <br />
    </b-card>
</div>
</template>
<template v-if="lessons == null || lessons == undefined || lessons.length==null">
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
