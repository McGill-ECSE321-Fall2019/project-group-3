package com.ecse321.group3.tutorME.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecse321.group3.tutorME.repository.ScheduleRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ScheduleTest {
	@Autowired
    private ScheduleRepository scheduleRepo;
	@Autowired
    private TestSuiteUtils testUtils;
	
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
	@Transactional
    public void createSchedule(){
        Schedule schedule = new Schedule();
        schedule.setSchedule_id(900);
       

        try{
            scheduleRepo.save(schedule);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getSchedule(){
        createSchedule();
        Assert.assertEquals(1, scheduleRepo.findAll().size());
    }
}
