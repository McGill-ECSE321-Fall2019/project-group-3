package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerServiceIF {

    Manager createManager(Manager manager) throws Exception;
    Manager getManager(String email) throws Exception;
    List<Manager> getManagers() throws Exception;
    Manager updateManager(String oldEmail, Manager manager) throws Exception;
    void deleteManager(String email) throws Exception;
}
