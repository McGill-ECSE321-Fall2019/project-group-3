package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Manager;
import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import com.ecse321.group3.tutorME.service.ManagerServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService implements ManagerServiceIF {

    @Autowired
    private UserEntityRepository managerRepo;

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
            manager = (Manager) managerRepo.getOne(email);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return manager;
    }

    @Override
    public List<Manager> getManagers() throws Exception {
        List<Manager> managers = null;

        try{
            //from user role repository, filter out the instances which are manager into a list
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
        Manager managerToDelete = this.getManager(email);
        try{
            managerRepo.deleteById(managerToDelete.getEmail());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
