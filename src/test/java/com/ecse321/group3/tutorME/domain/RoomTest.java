package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.Availabilities;
import com.ecse321.group3.tutorME.domain.enums.RoomSize;
import com.ecse321.group3.tutorME.repository.RoomRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomTest {

    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private TestSuiteUtils testUtils;
    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @Test
    @Transactional
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
