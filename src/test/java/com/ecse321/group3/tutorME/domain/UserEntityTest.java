package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserEntityRepository;
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
    private UserEntityRepository userEntityRepo;
    @Autowired
    private TestSuiteUtils testUtils;
    
    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @Test
    @Transactional
    public void createUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("testemail@email.com");
        userEntity.setFirstName("Test");
        userEntity.setPassword("hashedpass");

        try {
            userEntityRepo.save(userEntity);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void readUserEntity(){
        createUserEntity();
        Assert.assertEquals(1, userEntityRepo.findAll().size());
    }


}
