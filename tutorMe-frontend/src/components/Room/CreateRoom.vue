<template>
  <div>
      <center>
    <b-form class="mainForm">
      <b-form-group
        id="input-group-1"
        label="Number of Seats"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          type="number"
          required
          placeholder="Enter Number of Seats:"
        ></b-form-input>
      </b-form-group>
      <b-form-group
                id="input-group-2"
                label="Select Room size:"
                label-for="input-2"
              >
              <b-form-select :v-model="size_selected" :options="size_options"></b-form-select>
       </b-form-group>

        <b-form-group
                id="input-group-3"
                label="Choose room starting availability:"
                label-for="input-3"
              >
                <div>
                  <VueCtkDateTimePicker
                    :no-value-to-custom-elem="(true|false)"
                    input-class="form-control"
                    name="start"
                    label="Please enter lesson start time"
                    v-model="form.startTime"
                  ></VueCtkDateTimePicker>
                </div>
              </b-form-group>

              <b-form-group
                id="input-group-3"
                label="Choose room ending availability:"
                label-for="input-3"
              >
                <div>
                  <VueCtkDateTimePicker
                    :no-value-to-custom-elem="(true|false)"
                    input-class="form-control"
                    name="start"
                    label="Please enter Room availability ending time"
                    v-model="form.startTime"
                  ></VueCtkDateTimePicker>
                </div>
              </b-form-group>

      
      <b-button variant="primary">Create Room</b-button>
    </b-form>
    </center>
  </div>
</template>

<script src="../javascript/createroom.js"/>

