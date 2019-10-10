package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.Availabilities;
import com.ecse321.group3.tutorME.domain.enums.RoomSize;
import com.ecse321.group3.tutorME.repository.RoomRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomTest {

    @Autowired
    private RoomRepository roomRepo;

    @Test
    public void saveRoom(){
        Room room = new Room();
        room.setSize(RoomSize.BIG);
        room.setNumberOfSeats(10);
        room.setRoomAvailability(Availabilities.OPEN);

        try{
            roomRepo.save(room);
        } catch(Exception e){
            Assert.assertEquals(1, roomRepo.findAll().size());
        }
    }

    @Test
    public void getRoom(){
        saveRoom();
        Assert.assertEquals(1, roomRepo.findAll().size());
    }
}
