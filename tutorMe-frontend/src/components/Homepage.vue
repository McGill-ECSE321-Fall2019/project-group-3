<template>
<div>
	<div>
  <NavBar></NavBar>
  <vue-cal style="height: 700px" :events="events" :time-from="9 * 60" :time-to="21 * 60" :time-step="30" hide-weekends
  ></vue-cal>
</div>
</div>
</template>

<script src='./javascript/Homepage.js'/>