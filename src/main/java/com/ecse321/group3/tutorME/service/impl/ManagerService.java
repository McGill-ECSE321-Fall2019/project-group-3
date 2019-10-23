package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Manager;
import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import com.ecse321.group3.tutorME.service.ManagerServiceIF;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerService implements ManagerServiceIF {

    @Autowired
    private UserRoleRepository managerRepo;

    @Override
    public Manager createManager(Manager manager) throws Exception {
        Manager createdManager = null;

        try{
            createdManager = managerRepo.save(manager);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return createdManager;
    }

    @Override
    public Manager getManager(String email) throws Exception {
        Manager manager = null;

        try{
            manager = (Manager) managerRepo.findByUserEmail(email);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return manager;
    }

    @Override
    public List<Manager> getManagers() throws Exception {
        List<Manager> managers = null;

        try{
            managers = managerRepo.findAll().stream()
                    .filter(x -> x instanceof Manager)
                    .map(x -> (Manager) x)
                    .collect(Collectors.toList());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return managers;
    }

    @Override
    public Manager updateManager(String oldEmail, Manager manager) throws Exception {
        Manager updatedManager = null;

        try{
            deleteManager(oldEmail);
            updatedManager = createManager(manager);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return updatedManager;
    }

    @Override
    public void deleteManager(String email) throws Exception {

        try{
            managerRepo.deleteByUserEmail(email);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
