<template>
  <div>
      <center>
        <span class = "title"><b><font size="+3">Create a Room</font></b></span>
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
              <b-form-select v-model="form.size" :options="size_options"></b-form-select>
       </b-form-group>
      <b-button type="submit" variant="primary" v-if="update">Update Room</b-button>
      <b-button type="submit" variant="primary" v-else-if="update==false">Create Room</b-button>
    </b-form>
    </b-form>
    </center>
  </div>
</template>

<script src="../javascript/createroom.js"/>


<style scoped>
.mainForm{
    justify-content: center;
    align-content: center;
    width: 30%;
}
</style>
