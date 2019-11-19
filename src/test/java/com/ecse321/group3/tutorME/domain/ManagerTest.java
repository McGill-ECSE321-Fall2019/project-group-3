package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import com.ecse321.group3.tutorME.service.ManagerServiceIF;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerTest {
//
	@Autowired
    private ManagerServiceIF managerService;

	@Autowired
    private UserEntityRepository managerRepo;

//	@Autowired
//    private TestSuiteUtils testUtils;
//
//
//	Manager userForManager = null;
//	String emailForUser = "testemail@test.com";
//
//	@Before
//    public void init(){
//	    testUtils.truncateDatabase();
//    }
//
//	@Test
//    @Transactional
//    public void createManagerEntity(){
//        userForManager = new Manager();
//        userForManager.setEmail(emailForUser);
//
//		try{
//            managerService.createManager(userForManager);
//        } catch(Exception e){
//            Assert.fail(e.getMessage());
//        }
//    }
//
    @Test
    @Transactional
    public void getManager() throws Exception {
        Manager manager = new Manager();
        manager.setEmail("hello");
        managerRepo.save(manager);

        Optional<UserEntity> opt = managerRepo.findById(manager.getEmail());
        System.out.println(opt.isPresent());
        System.out.println(opt.get().getEmail());
        System.out.println(managerService.getManager(manager.getEmail()));
    }
//
//    @Test
//    @Transactional
//    public void updateManager() throws Exception{
//	    createManagerEntity();
//
//        userForManager = new Manager();
//        userForManager.setEmail("newemail");
//
//	    Assert.assertEquals(1, managerService.getManagers().size());
//
//	    managerService.updateManager(emailForUser, userForManager);
//
//	    Assert.assertEquals(1, managerService.getManagers().size());
//    }
//
//    @Test
//    @Transactional
//    public void getAllManagers() throws Exception{
//        createManagerEntity();
//        Assert.assertEquals(1, managerService.getManagers().size());
//    }
//
//    @Test
//    @Transactional
//    public void deleteManager() throws Exception{
//        userForManager = new Manager();
//        userForManager.setEmail(emailForUser);
//        userForManager.sa
//	    managerRepo.deleteById(managerService.getManagers().get(0).getUserId());
//	    Assert.assertEquals(0, managerService.getManagers().size());
//    }
//
	}
