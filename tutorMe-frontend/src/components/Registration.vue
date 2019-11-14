<template>
  <div>
      <center>
    <b-form @submit="register(firstname,lastname,email,password)" 
	value="register"
	class="mainForm">
      <b-form-group
        id="input-group-1"
        label="First Name:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.firstname"
          type="text"
          required
          placeholder="Enter first name"
        ></b-form-input>
      </b-form-group>
	  <b-form-group
        id="input-group-2"
        label="Last Name:"
        label-for="input-2"
      >
        <b-form-input
          id="input-2"
          v-model="form.lastname"
          type="text"
          required
          placeholder="Enter last name"
        ></b-form-input>
      </b-form-group>
	  <b-form-group
        id="input-group-3"
        label="Email address:"
        label-for="input-3"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-3"
          v-model="form.email"
          type="email"
          required
          placeholder="Enter email"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-4" label="Password:" label-for="input-4">
        <b-form-input
          id="input-4"
          v-model="form.password"
          type="password"
          required
          placeholder="Enter password"
        ></b-form-input>
      </b-form-group>

	  <b-form-group id="input-group-5" label="Confirm Password:" label-for="input-5">
        <b-form-input
          id="input-5"
          v-model="form.password"
          type="password"
          required
          placeholder="Enter password again"
        ></b-form-input>
      </b-form-group>
	   <b-form-checkbox
      id="checkbox-1"
      v-model="status"
      name="checkbox-1"
      value="accepted"
      unchecked-value="not_accepted"
    >
      I accept the Terms & Conditions
    </b-form-checkbox>

    <div>State: <strong>{{ status }}</strong></div>

      <b-button variant="primary">Sign Up</b-button>
    </b-form>
    </center>
  </div>
</template>

<script src='./javascript/Registration.js'/>


<style scoped>
.mainForm{
    justify-content: center;
    align-content: center;
    width: 30%;
}
</style>