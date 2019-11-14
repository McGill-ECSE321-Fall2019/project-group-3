<template>
  <div>
    <br />
    <br />
    <span class = "title">All Rooms</span>
    <router-link to="CreateRoom"><b-button pill variant="success" class="addButton">+</b-button></router-link>
    <hr />
    <center>
      <template v-if="hasRooms">
        <div class="mainForm">
          <b-list-group-item
            href="#"
            class="flex-column align-items-start"
            v-for="(room,idx) in rooms"
            :key="idx"
          >
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">Room ID: {{room.room_id}}</h5>
              <b-button
                v-on:click="deleteRoom(room.room_id)"
                pill
                variant="outline-danger"
              >Delete</b-button>
            </div>

            <p class="mb-1">
				<b-container class="bv-example-row">
  <b-row>
	<b-col><h5 class="mb-1">Lesson</h5>{{room.lesson}}</b-col>
    <b-col> <h5 class="mb-1">Seats</h5>{{room.numberOfSeats}}</b-col>
    <b-col><h5 class="mb-1">Size</h5>{{room.size}}</b-col>
  </b-row>
</b-container>
             <!-- This lesson is taught by {{lesson.tutor.name||"Tutor"}} for {{lesson.subject.subject_name||"Subject"}} + 
              {{lesson.course.courseName||"Course"}} at {{lesson.university.university_name||"University"}}.-->
              
            </p>

            <small class="text-muted">Click to update the room.</small>
          </b-list-group-item>
          <br />
          <br />
        </div>
      </template>
      <template v-else>
        <div>Uh-oh, there are no rooms to display!</div>
      </template>
    </center>
  </div>
</template>

<script src='./javascript/Room.js'/>

<style scoped>
.mainForm {
  width: 80%;
}
.title{
  flex:1; 
  text-align: center;
}
.addButton{
  flex: 1;
  float: right;
  margin-left: 25%;
  margin-right: 25%;
}
</style>