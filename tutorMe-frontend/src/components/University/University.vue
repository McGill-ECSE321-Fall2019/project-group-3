<template>
  <div>
    <br />
    <br />
    <span class="title">All Universities</span>
    <router-link to="CreateUniversity">
      <b-button pill variant="success" class="addButton">+</b-button>
    </router-link>
    <hr />
    <center>
      <template v-if="hasUniversities">
        <div class="mainForm">
          <b-list-group-item
            href="#"
            class="flex-column align-items-start"
            v-for="(university,idx) in universities"
            :key="idx"
          >
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">University Name: {{university.university_name}}</h5>
              <b-button
                v-on:click="deleteUniversity(university.university_name)"
                pill
                variant="outline-danger"
              >Delete</b-button>
            </div>

            <p class="mb-1">
            </p>

            <small class="text-muted"  v-on:click="updateUniversity(university.university_name)">Click to update the university.</small>
          </b-list-group-item>
          <br />
          <br />
        </div>
      </template>
      <template v-else>
        <div>Uh-oh, there are no universities to display!</div>
      </template>
    </center>
  </div>
</template>

<script src='../javascript/university.js'/>

<style scoped>
.mainForm {
  width: 80%;
}
.title {
  flex: 1;
  text-align: center;
}
.addButton {
  flex: 1;
  float: right;
  margin-left: 25%;
  margin-right: 25%;
}
</style>
