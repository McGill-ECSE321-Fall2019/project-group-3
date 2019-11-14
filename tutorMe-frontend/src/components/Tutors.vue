<template>
  <center>
    <br>
    <br>
<div class = "mainForm">
  <b-card-group deck>
  <b-card header="Card with list group">
    <b-list-group>
      <b-list-group-item href="#" class="flex-column align-items-start" v-for="index in 10" :key="index">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Tutor Name: tutor</h5>
    </div>

    <p class="mb-1">
      Some attributes to display for tutor. 
    </p>

    <small class="text-muted">Click to update the tutor.</small>
    </b-list-group-item>
    </b-list-group>

    <p class="card-text mt-2">
      Quis magna Lorem anim amet ipsum do mollit sit cillum voluptate ex nulla tempor. Laborum
      consequat non elit enim exercitation cillum aliqua consequat id aliqua. Esse ex consectetur
      mollit voluptate est in duis laboris ad sit ipsum anim Lorem.
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