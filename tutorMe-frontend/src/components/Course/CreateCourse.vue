<template>
  <div>
    <NavBar/>
    <br />
    <br />
    <span class = "title"><center><b><font size="+3">Create/Update a Course</font></b></center></span>
    <hr />
    <div>
      <div>
        <div class="mainForm">
          <b-card>
            <b-form @submit="onSubmit">

              <b-form-group
                id="input-group-21"
                label="Select associated subject:"
                label-for="input-21"
              >
                <b-form-input
                  required
                  list="input-list-21"
                  id="input-with-list-21"
                  placeholder="Search up a subject"
                  v-model="form.subject"
                ></b-form-input>
                <b-form-datalist id="input-list-21" :options="subjectOps"></b-form-datalist>
              </b-form-group>

              <b-form-group
                id="fieldset-1"
                label="Course Name:"
                label-for="input-5"
              >
                <b-form-input
                  id="type-text"
                  required
                  placeholder="Course Name"
                  v-model="form.courseName"
                ></b-form-input>
              </b-form-group>
              <b-button type="submit" variant="info">Create Course!</b-button>

            </b-form>
          </b-card>
        </div>
      </div>
    </div>
    <br />
    <br />
  </div>
</template>

<script src="../javascript/createcourse.js"/>

<style scoped>
.mainForm {
  margin-left: 20%;
  margin-right: 20%;
}
</style>