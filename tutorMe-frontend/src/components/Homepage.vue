<template>
<div>
	<div>
  <NavBar></NavBar>
  
  <vue-cal style="height: 700px" :events="events" :time-from="9 * 60" :time-to="21.5 * 60" :time-step="30" hide-weekends
  class="vuecal--blue-theme"
  
  ></vue-cal>
</div>
</div>
</template>

<script src='./javascript/Homepage.js'/>