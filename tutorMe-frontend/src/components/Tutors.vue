<template>
  <center>
    <NavBar/>
    <span class = "title"><center><b><font size="+3">All Tutors</font></b></center></span>
    <br>
    <h5 class="mb-1"> For all payroll-related information, please visit our payment partner: <a href="https://www.paypal.com">PayPal</a> </h5>
    <br>
    <hr />
    <div class = "mainForm">
      <template v-if="hasTutors">
        <b-card-group deck v-for="(tutor,idx) in tutors"
        :key="idx">
        <b-card>
          <template v-slot:header>
            <h5 class="mb-1"> {{tutor.firstName}} {{tutor.lastName}} </h5>
            <b-button
            class = "deleteButton"
            v-on:click="deleteTutor(tutor.email)"
            pill
            variant="outline-danger"
            >Fire tutor</b-button>
          </template>
          <div align = "left">
            <b-card-title> E-mail: {{tutor.email}}</b-card-title>
            <b-card-sub-title class="mb-2"> Rate: {{tutor.rate}} $/hr</b-card-sub-title>
            <b-card-sub-title class="mb-1"> Rating: {{getReviewScore(idx)}} </b-card-sub-title>

          </div>
          <div class="d-flex w-100 justify-content-between" v-if = "(tutor.reviews.length != 0)">
            <h5 class="mb-1"> Reviews: </h5>
          </div>
          <b-list-group>
            <b-list-group-item href="#" class="flex-column align-items-start" v-for="(review,review_idx) in tutor.reviews" :key="review_idx">
              <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1"> Review Score : {{review.rating}} </h5>
              </div>

              <p class="mb-1" align="left">
                Review comment: {{review.comment}} 
              </p>

              <div align = " right">
                <b-form-checkbox
                id="checkbox-1"
                v-model="review.isVisible"
                name="checkbox-1"
                @click.native="toggleVisibility(review, tutor)"
                >
                Visible Review
              </b-form-checkbox>

            </div>

          </b-list-group-item>
        </b-list-group>

        <div class="d-flex w-100 justify-content-between" v-if = "(tutor.courses_taught.length != 0)">
          <h5 class="mb-1"> Courses taught by {{tutor.firstName}} {{tutor.lastName}}: </h5>
        </div>

        <b-list-group>
          <b-list-group-item href="#" class="flex-column align-items-start" v-for="(taught_course,course_idx) in tutor.courses_taught":key="course_idx">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">{{taught_course.courseName}} </h5>
            </div>
          </b-list-group-item>

        </b-list-group>

        <div class="d-flex w-100 justify-content-between" v-if = "(tutor.courses_applied.length != 0)">
          <h5 class="mb-1"> Courses {{tutor.firstName}} {{tutor.lastName}} applied to teach: </h5>
        </div>

        <b-list-group>
          <b-list-group-item href="#" class="flex-column align-items-start" v-for="(applied_course,course_idx) in tutor.courses_applied":key="course_idx">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">{{applied_course.courseName}} </h5>
            </div>
            <div>
            <b-button
            class = "rejectButton"
            v-on:click="rejectCourse(tutor, applied_course)"
            pill
            variant="outline-danger"
            >Reject</b-button>

            <b-button
            class = "acceptButton"
            v-on:click="approveCourse(tutor,applied_course)"
            pill
            variant="outline-success"
            >Accept</b-button>
          </div>

          </b-list-group-item>
        </b-list-group>

      </b-card>
    </b-card-group>
  </template>
  <template v-else>
    <div>Uh-oh, there are no tutors to display!</div>
  </template>


</div>
</center>
</template>

<script src='./javascript/Tutors.js'/>


<style scoped>
  .mainForm{
    width: 80%; 
  }
  .deleteButton{
    float: right; 
  }
  .rejectButton{
    float: right;
    margin: 5px; 
  }  
  .acceptButton{
    float: right; 
    margin: 5px; 
  }
</style>
