<template>
  <center>
    <NavBar/>
    <span class = "title"><center><b><font size="+3">All Students</font></b></center></span>
    <br>
    <br>
    <hr />
    
    
    <div class = "mainForm">
      <template v-if="hasStudents">
        <b-card-group deck v-for="(student,idx) in students"
        :key="idx">
        <b-card>
          <template v-slot:header>
            <h5 class="mb-1"> {{student.firstName}} {{student.lastName}} </h5>

            <div align = "right">
             <b-button
             class = "deleteButton"
             v-on:click="deleteStudent(student.email)"
             pill
             variant="outline-danger"
             >Remove Student</b-button>
           </div>
         </template>
         <div align = "left">
          <p class="card-text mt-2">
            <b>E-mail:</b> {{student.email}}
          </p>
          <p class="card-text mt-2">
            <b>Reviews:</b>
          </p>
        </div>
        <b-list-group>
          <b-list-group-item  href="#" class="flex-column align-items-start"  v-for="(review, review_idx) in student.review" :key="review_idx">

            <div align = "left">
              <p class="card-text mt-2">
                <b>Review Comment:</b> {{review.comment}}
              </p>
            </div>
            <div align = " right">
              <b-form-checkbox
              id="checkbox-1"
              v-model="review.isVisible"
              name="checkbox-1"
              @click.native="toggleVisibility(review, student)"
              >
              Visible Review
            </b-form-checkbox>

          </div>
        </b-list-group-item>
      </b-list-group>
    </b-card>
  </b-card-group>
</template>
<template v-else>
  <div>Uh-oh, there are no students to display!</div>
</template>
</div>
</center>
</template>





<script src='./javascript/Students.js'/>
<style scoped>
  .mainForm{
    width: 80%;
  }
</style>
