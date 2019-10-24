package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Course;
import com.ecse321.group3.tutorME.domain.Room;
import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.repository.CourseRepository;
import com.ecse321.group3.tutorME.repository.RoomRepository;
import com.ecse321.group3.tutorME.service.CourseServiceIF;
import com.ecse321.group3.tutorME.service.RoomServiceIF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoomService implements RoomServiceIF {

    @Autowired
    private RoomRepository roomRepo;

    @Override
    public Room createRoom(Room room) throws Exception {
        //THIS METHOD WILL DO THE ACTUAL CODE IMPLEMENTATION.
        Room roomCreated = null;

        //create the course, by saving to the database.
        try {
            roomCreated = roomRepo.save(room);
        } catch(Exception e){
            //if we get errors saving to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return roomCreated;
    }

    @Override
    public Room getRoom(int roomID) throws Exception {
    	Room roomCreated = null;

        //create the course, by saving to the database.
        try {
            roomCreated = roomRepo.findById(roomID).get();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return roomCreated;    
        }

    @Override
    public List<Room> getRooms() throws Exception {
        List<Room> rooms = null;

        //create the course, by saving to the database.
        try {
            rooms = roomRepo.findAll();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return rooms;     
        }

    @Override
    public void deleteRoom(int roomID) throws Exception {
        //delete the course
        try {
            roomRepo.deleteById(roomID);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
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
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return roomUpdated; 
    }


}