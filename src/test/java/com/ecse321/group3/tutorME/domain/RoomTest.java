package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.RoomSize;
import com.ecse321.group3.tutorME.repository.RoomRepository;
import com.ecse321.group3.tutorME.service.RoomServiceIF;
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
	private RoomServiceIF roomService;

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
    public void createRoom(){
        Room room = new Room();
        room.setRoom_id(300);

        try{
            roomService.createRoom(room);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    public void getRoom() throws Exception {
        createRoom();
        Assert.assertEquals(300, roomService.getRoom(300).getRoom_id());
    }

	@Test
	@Transactional
	public void updateRoom() throws Exception {
		createRoom();

		Room newRoom = new Room();
		newRoom.setRoom_id(200);

		try {
			roomService.updateRoom(300, newRoom);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		try {
			roomService.getRoom(300);
		} catch(Exception e){
		}
		Assert.assertEquals(200, roomService.getRoom(200).getRoom_id());
	}

	@Test
	@Transactional
	public void getAllRooms() throws Exception{
		createRoom();
		Room newRoom = new Room();
		newRoom.setRoom_id(200);
		roomService.createRoom(newRoom);

		Assert.assertEquals(2, roomService.getRooms().size());
	}

	@Test
	@Transactional
	public void deleteRoom() throws Exception{
		createRoom();
		roomService.deleteRoom(300);
		Assert.assertEquals(0, roomService.getRooms().size());
	}


}
