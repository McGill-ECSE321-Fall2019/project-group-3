package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserEntityServiceIF {

    //Creating an interface for all the methods a userEntity will have.
    UserEntity createUserEntity(UserEntity userEntity) throws Exception;
    UserEntity getUserEntity(String email) throws Exception;
    List<UserEntity> getUserEntities() throws Exception;
    // TODO: Update methods
    void deleteUserEntity(String courseName) throws Exception;
}
