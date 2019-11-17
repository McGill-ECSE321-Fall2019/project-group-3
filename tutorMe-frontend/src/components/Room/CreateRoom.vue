<template>
  <div>
      <center>
    <b-form class="mainForm">
      <b-form @submit="onSubmit">
      <b-form-group
        id="input-group-1"
        label="Number of Seats"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          type="number"
          v-model="form.numberOfSeats"
          required
          placeholder="Enter Number of Seats:"
        ></b-form-input>
      </b-form-group>
      <b-form-group
                id="input-group-2"
                label="Select Room size:"
                label-for="input-2"
              >
              <b-form-select :v-model="form.roomSize" :options="size_options"></b-form-select>
       </b-form-group>
      <b-button type="submit" variant="primary">Create Room</b-button>
    </b-form>
    </b-form>
    </center>
  </div>
</template>

<script src="../javascript/createroom.js"/>

