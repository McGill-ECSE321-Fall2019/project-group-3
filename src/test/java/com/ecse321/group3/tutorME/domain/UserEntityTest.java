package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import com.ecse321.group3.tutorME.service.UserEntityServiceIF;
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
public class UserEntityTest {

	@Autowired
	private UserEntityServiceIF userService;
    @Autowired
    private UserEntityRepository userRepo;
    @Autowired
    private TestSuiteUtils testUtils;
    
    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @Test
    @Transactional
    public void createUserEntity(){
        UserEntity user = new UserEntity();
        user.setEmail("email");

        try {
            userService.createUserEntity(user);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getUserEntity() throws Exception{
        createUserEntity();
        Assert.assertEquals("email", userService.getUserEntity("email").getEmail());
    }
    
    @Test
    @Transactional
    public void updateUserEntity() throws Exception{
        createUserEntity();
        
        UserEntity user = new UserEntity();
        user.setEmail("test");
        
        try {
        	userService.updateUserEntity("email", user);
        }
        catch (Exception e) {
        	Assert.fail(e.getMessage());
        }
        
        try {
        	userService.getUserEntity("email");
        }
        catch (Exception e) {
        	//all good.
        }
        
        Assert.assertEquals("test", userService.getUserEntity("test").getEmail());
    }
    
    @Test
    @Transactional
    public void getUserEntities() throws Exception {
    	createUserEntity();
    	UserEntity user = new UserEntity();
    	user.setEmail("test");
    	userService.createUserEntity(user);
    	
		Assert.assertEquals(2, userService.getUserEntities().size());
    }
    
	@Test
	@Transactional
	public void deleteUserEntity() throws Exception{
		createUserEntity();
		userService.deleteUserEntity("email");
		Assert.assertEquals(0, userService.getUserEntities().size());
	}
	
	@Test
	@Transactional
	public void verifyUsers() throws Exception{
		UserEntity user = new UserEntity();
        user.setEmail("email");
        userService.createUserEntity(user);
		Assert.assertEquals(false, userService.getUserEntity("email").getVerified());
		user.setUserRole(new Tutor());
		userService.updateUserEntity("email", user);
		Assert.assertEquals(true, userService.getUserEntity("email").getVerified());
	}
}
