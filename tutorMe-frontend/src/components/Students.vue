<template>
  <center>
    <br>
    <br>
<!-- <ul class="list-group">

  <li class="list-group-item d-flex justify-content-between align-items-center">
    Mout
    <span class="badge badge-primary badge-pill">1</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Jason
    <span class="badge badge-primary badge-pill">2</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Daou
    <span class="badge badge-primary badge-pill"></span>
  </li>
</ul> -->

<div class="accordion" id="accordionExample">
  <div class="card" v-for="index in 3" :key="index">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" >
          Lesson #1
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample" v-for="index in 1" :key="index">
      <b-list-group>
  <b-list-group-item href="#some-link">Karl</b-list-group-item>
  <b-list-group-item href="#">Jason</b-list-group-item>
  <b-list-group-item href="#">Nicolas</b-list-group-item>
  <b-list-group-item href="#">Preyansh</b-list-group-item>
  <b-list-group-item href="#">Elie</b-list-group-item>


</b-list-group>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
           Lesson #2
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
         karl le roi
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingThree">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Lesson #3
        </button>
      </h2>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
      <div class="card-body">
      karl le roi
      </div>
    </div>
  </div>
</div>



  </center>
</template>


<style scoped>
.mainForm{
  width: 80%;
}
</style>
