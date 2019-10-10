package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserEntityTest {

    @Autowired
    private UserEntityRepository userEntityRepo;

    @Test
    public void createUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("testemail@email.com");
        userEntity.setFirstName("Test");
        userEntity.setPassword("hashedpass");

        try {
            userEntityRepo.save(userEntity);
        } catch(Exception e){
            Assert.fail("Failed to save user");
        }
    }

    @Test
    public void readUserEntity(){
        createUserEntity();
        Assert.assertEquals(1, userEntityRepo.findAll().size());
    }


}
