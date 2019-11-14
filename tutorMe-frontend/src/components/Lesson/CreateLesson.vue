<template>
  <div>
    <div>
      <div>
        <div class="mainForm">
          <b-card>
            <b-form @submit="onSubmit">
              <b-form-group
                id="input-group-1"
                label="Select associated course:"
                label-for="input-1"
              >
                <b-form-input list="input-list" id="input-with-list"></b-form-input>
                <b-form-datalist id="input-list" :options="courseOps"></b-form-datalist>
              </b-form-group>

              <b-form-group id="input-group-2" label="Select associated room:" label-for="input-2">
                <b-form-input list="input-list" id="input-with-list"></b-form-input>
                <b-form-datalist id="input-list" :options="courseOps"></b-form-datalist>
              </b-form-group>

              <b-form-group id="input-group-3" label="Add students to lesson:" label-for="input-3">
                <multiselect
                  v-model="form.student"
                  :options="courseOps"
                  :searchable="true"
                  :close-on-select="false"
                  :multiple="true"
                  :show-labels="false"
                  placeholder="Pick students"
                ></multiselect>
              </b-form-group>

              <b-form-group id="input-group-4" label="Add tutors to leson:" label-for="input-4">
                <multiselect
                  v-model="form.tutor"
                  :options="courseOps"
                  :searchable="true"
                  :close-on-select="false"
                  :multiple="true"
                  :show-labels="false"
                  placeholder="Pick tutors"
                ></multiselect>
              </b-form-group>

              <b-button type="submit" variant="primary">Create Lesson!</b-button>
            </b-form>
          </b-card>
        </div>
      </div>
    </div>
  </div>

  <!-- <div>
            <VueCtkDateTimePicker
            :no-value-to-custom-elem="(true|false)"
              input-class="form-control"
              name="start"
              label="Please enter lesson start time"
              v-model="form.startTime"
              dark>
            </VueCtkDateTimePicker>

            <button v-on:click="printDate()">show me your date</button>
  </div>-->
</template>

<script src="../javascript/createlesson.js"/>

<style scoped>
.mainForm {
  margin-left: 20%;
  margin-right: 20%;
}
</style>