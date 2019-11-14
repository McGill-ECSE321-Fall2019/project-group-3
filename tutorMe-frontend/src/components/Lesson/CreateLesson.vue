<template>
<div>
    component is here:
    <div>
            <VueCtkDateTimePicker
            :no-value-to-custom-elem="(true|false)"
              input-class="form-control"
              name="start"
              label="Please enter lesson start time"
              v-model="form.startTime"
              dark>
            </VueCtkDateTimePicker>

            <button v-on:click="printDate()">show me your date</button>
    </div>
</div>
</template>

<script src="../javascript/createlesson.js"/>