package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import com.ecse321.group3.tutorME.repository.UserRoleRepository;
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

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerTest {
	
	@Autowired
    private ManagerServiceIF managerService;

	@Autowired
    private UserRoleRepository managerRepo;

	@Autowired
    private TestSuiteUtils testUtils;

	@Autowired
    private UserEntityRepository userEntityRepository;

	UserEntity userForManager = null;
	String emailForUser = "testemail@test.com";

	@Before
    public void init(){
	    testUtils.truncateDatabase();
    }

	@Test
    @Transactional
    public void createManagerEntity(){
		Manager manager = new Manager();
		manager.setUserId(100);

        userForManager = new UserEntity();
        userForManager.setEmail(emailForUser);
		userForManager.setUserRole(manager);

		manager.setUser(userForManager);


		try{
            managerService.createManager(manager);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getManager() throws Exception {
        Manager manager = new Manager();
        manager.setUserId(100);

        userForManager = new UserEntity();
        userForManager.setEmail(emailForUser);
        userForManager.setUserRole(manager);

        manager.setUser(userForManager);
        userEntityRepository.save(userForManager);
        Assert.assertEquals(emailForUser, managerService.getManager(emailForUser).getUser().getEmail());
    }

    @Test
    @Transactional
    public void updateManager() throws Exception{
	    createManagerEntity();
	    Manager newManager = new Manager();
	    newManager.setUserId(121);

	    Assert.assertEquals(1, managerService.getManagers().size());

	    managerService.updateManager(emailForUser, newManager);

	    Assert.assertEquals(1, managerService.getManagers().size());
    }

    @Test
    @Transactional
    public void getAllManagers() throws Exception{
        createManagerEntity();
        Assert.assertEquals(1, managerService.getManagers().size());
    }

    @Test
    @Transactional
    public void deleteManager() throws Exception{
	    UserEntity createUser = new UserEntity();
	    createUser.setEmail(emailForUser);
	    Manager manager = new Manager();
	    createUser.setUserRole(manager);
        manager.setUser(createUser);
        managerService.createManager(manager);
	    userEntityRepository.save(createUser);

	    managerRepo.deleteById(managerService.getManagers().get(0).getUserId());
	    Assert.assertEquals(0, managerService.getManagers().size());
    }

	}
