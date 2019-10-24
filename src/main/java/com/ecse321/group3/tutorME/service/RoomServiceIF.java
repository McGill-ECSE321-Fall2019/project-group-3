package com.ecse321.group3.tutorME.service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ecse321.group3.tutorME.domain.Room;
@Service
public interface RoomServiceIF {
	
    Room createRoom(Room room) throws Exception;
    Room getRoom(int room_id) throws Exception;
    List<Room> getRooms() throws Exception;
  
    void deleteRoom(int room_id) throws Exception;
	Room updateRoom(int oldId, Room room);
  

}
