<template>
  <div>
    <NavBar/>
    <br />
    <br />
    <span class = "title"><center><b><font size="+3">Create/Update a University</font></b></center></span>
    <hr />
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

              <b-button type="submit" variant="info" v-if="update">Update University</b-button>
              <b-button type="submit" variant="info" v-else-if="update==false">Create University</b-button>
              
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