<template>
  <div>
    
   <NavBar/>

   <form>
  <div class="form-group">
    <label for="exampleInputEmail1">Number of Seats</label>
    <input type="number" class="form-control" id="numberOfSeats" placeholder="Number of seats in Room">
</div>
<div class="form-group">
      <label for="RoomSize">Room Size</label>
      <select id="inputRoomSize" class="form-control">
        <option>BIG</option>
        <option>SMALL</option>
      </select>
    </div>
    
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  </div>
  </template>

