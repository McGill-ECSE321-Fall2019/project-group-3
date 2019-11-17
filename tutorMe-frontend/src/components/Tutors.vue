<template>
  <center>
    <NavBar/>
    <span class = "title"><center><b><font size="+3">All Tutors</font></b></center></span>
    <br>
    <br>
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
            <b-card-sub-title> rate: {{tutor.rate}}</b-card-sub-title>
          </div>
          <b-list-group>
            <b-list-group-item href="#" class="flex-column align-items-start" v-for="(review,review_idx) in tutor.reviews" :key="review_idx">
              <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1"> {{review.rating}} </h5>
              </div>

              <p class="mb-1">
                {{review.comment}} 
              </p>

              <div>
                <b-form-checkbox
                id="checkbox-1"
                v-model="review.isVisible"
                name="checkbox-1"
                @click.native="toggleVisibility(review, tutor)"
                >
                Visible Review
              </b-form-checkbox>

              <div>State: <strong>{{ review.isVisible }}</strong></div>
            </div>

          </b-list-group-item>
        </b-list-group>

        <b-list-group>
          <b-list-group-item href="#" class="flex-column align-items-start" v-for="(course,course_idx) in tutor.courses_taught":key="course_idx">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">Example course {{tutor.email}} </h5>
            </div>

            <p class="mb-1">
              Course information. 
            </p>

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
</style>
