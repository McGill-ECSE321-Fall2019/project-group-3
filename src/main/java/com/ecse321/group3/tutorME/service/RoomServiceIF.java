package com.ecse321.group3.tutorME.service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ecse321.group3.tutorME.domain.Room;
@Service
public interface RoomServiceIF {
	
	//Creating an interface for all the methods a subject will have.
    Room createRoom(Room room) throws Exception;
    Room getRoom(int room_id) throws Exception;
    List<Room> getRooms() throws Exception;
    //todo: update.
    void deleteRoom(int room_id) throws Exception;
  

}
