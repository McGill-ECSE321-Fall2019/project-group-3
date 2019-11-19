<template>
  <div>
      <center>
    <b-form class="mainForm">
      <b-form-group
        id="input-group-1"
        label="Email address:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          required
          placeholder="Enter email"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Your Password:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.password"
          type="password"
          required
          placeholder="Enter password"
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary" v-on:click="checkPassword()">Login</b-button>
      <b-button type="submit" @click="$router.push('registration')">Or Sign Up!</b-button>
    </b-form>
    </center>
  </div>
</template>

<script src='./javascript/Welcome.js'/>

<style scoped>
.mainForm{
    justify-content: center;
    align-content: center;
    width: 30%;
}
</style>