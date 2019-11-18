<template>

  <center>
    <NavBar/>
    <span class = "title"><center><b><font size="+3">All Students</font></b></center></span>
    <br>
    <br>
    <hr />
    
    
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
              E-mail: {{student.email}}
            </p>
          </div>
    <b-list-group>
      <b-list-group-item href="#" class="flex-column align-items-start" v-for="(review, review_idx) in student.reviews" :key="review_idx">
    </b-list-group-item>
    </b-list-group>
    <div align = "left">
    <p class="card-text mt-2">
      Review: {{student.reviews}}
    </p>
  </div>
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