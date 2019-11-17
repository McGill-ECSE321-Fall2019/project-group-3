<template>
  <center>
    <br>
    <br>
<div class = "mainForm">
  <b-card-group deck v-for="(student,idx) in students"
            :key="idx">
  <b-card>
        <template v-slot:header>

             <div align = "center">
                <b-card-title> {{student.firstName}} {{student.lastName}}
                </b-card-title>
              </div>
          </h5>

        </template>
          <div align = "left">
            <p class="card-text mt-2">
              <b>E-mail:</b> {{student.email}}
            </p>
          </div>
    <b-list-group>
        <b-list-group-item href="#" class="flex-column align-items-start"  v-for="(review, review_idx) in student.reviews" :key="review_idx">

          <div align = "left">
            <p class="card-text mt-2">
              <b>Review:</b> {{review.comment}}
            </p>
          </div>

          </b-list-group-item>
      </b-list-group>
    </b-card>
  </b-card-group>
</div>
  </center>
</template>



<script src='./javascript/Students.js'/>
<style scoped>
.mainForm{
  width: 80%;
}
</style>
