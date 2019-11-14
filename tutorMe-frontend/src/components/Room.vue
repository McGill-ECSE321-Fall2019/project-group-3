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
              <h5 class="mb-1">Room ID: {{room.roomId}}</h5>
              <b-button
                v-on:click="deleteRoom(room.roomId)"
                pill
                variant="outline-danger"
              >Delete</b-button>
            </div>

            <p class="mb-1">
              
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