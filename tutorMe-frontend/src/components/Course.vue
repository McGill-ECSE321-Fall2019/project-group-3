<template>
  <center>
    <NavBar/>
    <br>
    <br>
<div class = "mainForm">
   <b-list-group-item href="#" class="flex-column align-items-start" v-for="index in 10" :key="index">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Course ID: id</h5>
       <b-button pill variant="outline-danger">Delete</b-button>
    </div>

    <p class="mb-1">
      This course falls under the "Subject"  at "University". 
    </p>

    <small class="text-muted">Click to update the course.</small>
  </b-list-group-item>

</div>
  </center>
</template>

<style scoped>
.mainForm{
  width: 80%; 
}
</style>