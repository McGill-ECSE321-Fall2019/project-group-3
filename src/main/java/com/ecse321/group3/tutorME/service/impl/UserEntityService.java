package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.UserEntity;
import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import com.ecse321.group3.tutorME.service.UserEntityServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService implements UserEntityServiceIF {

    @Autowired
    private UserEntityRepository userEntityRepo;

    @Override
    public UserEntity createUserEntity(UserEntity user) throws Exception {
        UserEntity userCreated = null;

        try {
            userCreated = userEntityRepo.save(user);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return userCreated;
    }

    @Override
    public UserEntity getUserEntity(String email) throws Exception {
        UserEntity user = null;

        try {
            user = userEntityRepo.findById(email).get();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return user;    
        }

    @Override
    public List<UserEntity> getUserEntities() throws Exception {
        List<UserEntity> users = null;
        try {
            users = userEntityRepo.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return users;     
        }

    @Override
    public void deleteUserEntity(String email) throws Exception {
        try {
            userEntityRepo.deleteById(email);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return; 
    }
}