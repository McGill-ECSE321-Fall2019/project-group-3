package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Room;
import com.ecse321.group3.tutorME.repository.RoomRepository;

import com.ecse321.group3.tutorME.service.RoomServiceIF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements RoomServiceIF {

    @Autowired
    private RoomRepository roomRepo;

    @Override
    public Room createRoom(Room room) throws Exception {
      
        Room roomCreated = null;

        try {
            roomCreated = roomRepo.save(room);
        } catch(Exception e){
           
            throw new Exception(e.getMessage());
        }

   
        return roomCreated;
    }

    @Override
    public Room getRoom(int roomID) throws Exception {
    	Room roomCreated = null;

        
        try {
            roomCreated = roomRepo.findById(roomID).get();
        } catch(Exception e){
           
            throw new Exception(e.getMessage());
        }

        
        return roomCreated;    
        }

    @Override
    public List<Room> getRooms() throws Exception {
        List<Room> rooms = null;

     
        try {
            rooms = roomRepo.findAll();
        } catch(Exception e){
           
            throw new Exception(e.getMessage());
        }


        return rooms;     
        }

    @Override
    public void deleteRoom(int roomID) throws Exception {
        
        try {
            roomRepo.deleteById(roomID);
        } catch(Exception e){
       
            throw new Exception(e.getMessage());
        }
        return; 
    }

	@Override
	public Room updateRoom(int oldId, Room room) throws Exception {
		Room roomUpdated = null;
        try {
            roomRepo.deleteById(oldId);
            roomUpdated = roomRepo.save(room);
        } catch(Exception e){
            
            throw new Exception(e.getMessage());
        }
        return roomUpdated; 
    }


}