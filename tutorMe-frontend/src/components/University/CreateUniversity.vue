<template>
  <div>
    <div>
      <div>
        <div class="mainForm">
          <b-card>
            <b-form @submit="onSubmit">
              <b-form-group
                id="input-groupx-1"
                label="University Name:"
                label-for="inputx-1"
              >
                <b-form-input
                  id="inputx-1"
                  v-model="form.university_name"
                  type="text"
                  required
                  placeholder="Enter name of university:"
                ></b-form-input>
              </b-form-group>
              <b-form-group
                id="inputx-group-3"
                label="Add subjects to university:"
              >
                <multiselect
                  v-model="form.subjects"
                  :options="subjectOps"
                  :searchable="true"
                  :close-on-select="false"
                  :multiple="true"
                  :show-labels="false"
                ></multiselect>
              </b-form-group>

              <b-button type="submit" variant="primary" v-if="update">Update Lesson!</b-button>
              <b-button type="submit" variant="primary" v-else-if="update==false">Create Lesson!</b-button>
              
            </b-form>
          </b-card>
        </div>
      </div>
    </div>
    <br />
    <br />
  </div>
</template>

<script src="../javascript/createuniversity.js"/>

<style scoped>
.mainForm {
  margin-left: 20%;
  margin-right: 20%;
}
</style>