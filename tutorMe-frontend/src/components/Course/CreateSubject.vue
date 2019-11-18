<template>
  <div>
    <div>
      <div>
        <div class="mainForm">
          <b-card>
            <b-form @submit="onSubmit">

              <b-form-group
                id="input-group-21"
                label="Select associated University:"
                label-for="input-21"
              >
                <b-form-input
                  list="input-list-21"
                  id="input-with-list-21"
                  required
                  placeholder="Search up a university"
                  v-model="form.university"
                ></b-form-input>
                <b-form-datalist id="input-list-21" :options="universityOps"></b-form-datalist>
              </b-form-group>

              <b-form-group
                id="fieldset-1"
                label="Subject Name:"
                label-for="input-5"
              >
                <b-form-input
                  id="type-text"
                  required
                  placeholder="Subject Name"
                  v-model="form.subject_name"
                ></b-form-input>
              </b-form-group>
              <b-button type="submit" variant="info">Create Subject</b-button>
            </b-form>
          </b-card>
        </div>
      </div>
    </div>
    <br />
    <br />
  </div>
</template>

<script src="../javascript/createsubject.js"/>

<style scoped>
.mainForm {
  margin-left: 20%;
  margin-right: 20%;
}
</style>