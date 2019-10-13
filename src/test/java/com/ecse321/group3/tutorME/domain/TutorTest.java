package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class TutorTest {
	
	@Autowired
    private UserRoleRepository tutorRepo;
	@Autowired
    private TestSuiteUtils testUtils;
	
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
	@Transactional
    public void createTutor(){
        Tutor tutor = new Tutor();
        tutor.setRate(60.23);
        tutor.setUserId(123);

        try{
            tutorRepo.save(tutor);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getTutor(){
       createTutor();
        Assert.assertEquals(1, tutorRepo.findAll().size());
    }
	
	
}
