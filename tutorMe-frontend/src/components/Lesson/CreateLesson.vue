<template>
  <div>
    <NavBar/>
    <br />
    <br />
    <div>
      <div>
        <span class = "title"><center><b><font size="+3">Create/Update a Lesson</font></b></center></span>
        <hr />
        <div class="mainForm">
          <b-card>
            <b-form @submit="onSubmit">
              <b-form-group
                id="input-group-1"
                label="Select associated course:"
                label-for="input-1"
              >
                <b-form-input
                  list="input-list"
                  id="input-with-list"
                  placeholder="Search up a course"
                  v-model="form.course"
                  required
                ></b-form-input>
                <b-form-datalist id="input-list" :options="courseOps"></b-form-datalist>
              </b-form-group>

              <b-form-group
                id="input-group-21"
                label="Select associated room:"
                label-for="input-21"
              >
                <b-form-input
                  list="input-list-21"
                  id="input-with-list-21"
                  placeholder="Search up a room"
                  v-model="form.room"
                ></b-form-input>
                <b-form-datalist id="input-list-21" :options="roomOps" v-model="form.room"></b-form-datalist>
              </b-form-group>

              <b-form-group
                id="input-group-5"
                label="Choose lesson start time:"
                label-for="input-5"
              >
                <div>
                  <VueCtkDateTimePicker
                    :no-value-to-custom-elem="(true|false)"
                    input-class="form-control"
                    name="start"
                    label="Please enter lesson start time"
                    v-model="form.startTime"
                    format="YYYY-MM-DDTHH:mm:ss"
                  ></VueCtkDateTimePicker>
                </div>
              </b-form-group>

              <b-form-group id="input-group-6" label="Choose lesson end time:" label-for="input-6">
                <div>
                  <VueCtkDateTimePicker
                    :no-value-to-custom-elem="(true|false)"
                    input-class="form-control"
                    name="start"
                    label="Please enter lesson end time"
                    v-model="form.endTime"
                    format="YYYY-MM-DDTHH:mm:ss"
                  ></VueCtkDateTimePicker>
                </div>
              </b-form-group>

              <b-form-group id="input-group-3" label="Add students to lesson:" label-for="input-3">
                <multiselect
                  v-model="form.student"
                  :options="studentOps"
                  :searchable="true"
                  :close-on-select="false"
                  :multiple="true"
                  :show-labels="false"
                ></multiselect>
              </b-form-group>

              <b-form-group id="input-group-4" label="Add tutors to leson:" label-for="input-4">
                <multiselect
                  v-model="form.tutor"
                  :options="tutorOps"
                  :searchable="true"
                  :close-on-select="false"
                  :multiple="true"
                  :show-labels="false"
                ></multiselect>
              </b-form-group>

              <b-button type="submit" variant="info" v-if="update">Update Lesson!</b-button>
              <b-button type="submit" variant="info" v-else-if="update==false">Create Lesson!</b-button>
            </b-form>
          </b-card>
        </div>
      </div>
    </div>
    <br />
    <br />
  </div>
</template>

<script src="../javascript/createlesson.js"/>

<style scoped>
.mainForm {
  margin-left: 20%;
  margin-right: 20%;
}
</style>