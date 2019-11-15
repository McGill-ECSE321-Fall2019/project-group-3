<template>
  <div>
    <div>
      <div>
        <div class="mainForm">
          <b-card>
            <b-form @submit="onSubmit">
              <b-form-group
                id="input-group-1"
                label="Select associated university:"
                label-for="input-1"
              >
                <b-form-input
                  list="input-list"
                  id="input-with-list"
                  placeholder="Search up a university"
                ></b-form-input>
                <b-form-datalist id="input-list" :options="universityOps" v-model="form.university"></b-form-datalist>
              </b-form-group>

              <b-form-group
                id="input-group-21"
                label="Select associated subject:"
                label-for="input-21"
              >
                <b-form-input
                  list="input-list-21"
                  id="input-with-list-21"
                  placeholder="Search up a subject"
                ></b-form-input>
                <b-form-datalist id="input-list-21" :options="subjectOps" v-model="form.subject"></b-form-datalist>
              </b-form-group>

              <b-form-group
                id="fieldset-1"
                label="Course Name:"
                label-for="input-5"
              >
                <b-form-input
                  id="type-text"
                  placeholder="Course Name"
                ></b-form-input>
                <b-form-datalist id="type-text" v-model="form.name"></b-form-datalist>
              </b-form-group>

              <b-button type="submit" variant="primary">Create Course!</b-button>
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