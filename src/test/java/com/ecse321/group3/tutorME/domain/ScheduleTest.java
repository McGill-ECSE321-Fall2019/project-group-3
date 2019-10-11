package com.ecse321.group3.tutorME.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ecse321.group3.tutorME.repository.ScheduleRepository;

@SpringBootTest
public class ScheduleTest {
	@Autowired
    private ScheduleRepository scheduleRepo;
	
	@Test
    public void saveSchedule(){
        Schedule schedule = new Schedule();
        schedule.setSchedule_id(900);
       

        try{
            scheduleRepo.save(schedule);
        } catch(Exception e){
            Assert.assertEquals(1, scheduleRepo.findAll().size());
        }
    }

    @Test
    public void getSchedule(){
        saveSchedule();
        Assert.assertEquals(1, scheduleRepo.findAll().size());
    }
}
