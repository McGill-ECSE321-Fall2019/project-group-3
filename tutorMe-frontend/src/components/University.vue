<template>
  <center>
    <br>
    <br>
<div class = "mainForm">
   <b-list-group-item href="#" class="flex-column align-items-start" v-for="index in 10" :key="index">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">University Name: university</h5>
       <b-button pill variant="outline-danger">Delete</b-button>
    </div>

    <p class="mb-1">
      Some attributes to display for university.
    </p>

    <small class="text-muted">Click to update the university.</small>
  </b-list-group-item>

</div>
  </center>
</template>

<style scoped>
.mainForm{
  width: 80%;
}
</style>
