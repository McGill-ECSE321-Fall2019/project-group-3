package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecse321.group3.tutorME.repository.ManagerRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerTest {
	
	@Autowired
    private ManagerRepository ManagerEntityRepo;

	@Autowired
    private TestSuiteUtils testUtils;

	@Before
    public void init(){
        testUtils.truncateDatabase();
    }

	@Test
    public void createManagerEntity(){
		Manager manager = new Manager();
		manager.setManagerId(267);
		
		try{
            ManagerEntityRepo.save(manager);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getManager(){
        createManagerEntity();
        Assert.assertEquals(1, ManagerEntityRepo.findAll().size());
    }
	
		
		
	}
