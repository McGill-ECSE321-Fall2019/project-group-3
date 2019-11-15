<template>
  <center>
    <br>
    <br>
<div class = "mainForm">
  <b-card-group deck v-for="index in 10" :key="index">
  <b-card header="Tutor name" >
    <b-list-group>
      <b-list-group-item href="#" class="flex-column align-items-start" v-for="index in 3" :key="index">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Example course</h5>
    </div>

    <p class="mb-1">
      Course information. 
    </p>

    </b-list-group-item>
    </b-list-group>

    <p class="card-text mt-2">
      Review summary
    </p>
  </b-card>
  </b-card-group>



</div>
  </center>
</template>

<style scoped>
.mainForm{
  width: 80%; 
}
</style>