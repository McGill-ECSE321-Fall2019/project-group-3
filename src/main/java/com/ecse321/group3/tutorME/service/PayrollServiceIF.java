package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Payroll;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayrollServiceIF {

    //Creating an interface for all the methods a payroll will have.
    Payroll createPayroll(Payroll payroll) throws Exception;
    Payroll getPayroll(int id) throws Exception;
    List<Payroll> getPayrolls() throws Exception;
    Payroll updatePayroll(int oldId, Payroll payroll) throws Exception;
    void deletePayroll(int id) throws Exception;
}






