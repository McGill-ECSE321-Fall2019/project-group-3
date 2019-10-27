package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Lesson;
import com.ecse321.group3.tutorME.domain.Payroll;
import com.ecse321.group3.tutorME.repository.PayrollRepository;
import com.ecse321.group3.tutorME.service.PayrollServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService implements PayrollServiceIF {

    @Autowired
    private PayrollRepository payrollRepo;

    @Override
    public Payroll createPayroll(Payroll payroll) throws Exception {
        //THIS METHOD WILL DO THE ACTUAL CODE IMPLEMENTATION.
        Payroll payrollCreated = null;

        //create the payroll, by saving to the database.
        try {
            payrollCreated = payrollRepo.save(payroll);
        } catch(Exception e){
            //if we get errors saving to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the payroll we created.
        return payrollCreated;
    }

    @Override
    public Payroll getPayroll(int id) throws Exception {
        Payroll payrollCreated = null;

        //create the payroll, by saving to the database.
        try {
            payrollCreated = payrollRepo.findById(id).get();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the payroll we created.
        return payrollCreated;
        }

    @Override
    public List<Payroll> getPayrolls() throws Exception {
        List<Payroll> payrolls = null;

        //create the payroll, by saving to the database.
        try {
            payrolls = payrollRepo.findAll();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the payroll we created.
        return payrolls;
        }

    @Override
    public Payroll updatePayroll(int oldId, Payroll payroll) throws Exception {
        Payroll payroll_updated = null;

        try {
            payrollRepo.deleteById(oldId);
            payroll_updated = payrollRepo.save(payroll);
        }catch (Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return payroll_updated;
    }

    @Override
    public void deletePayroll(int id) throws Exception {
        //delete the lesson

        try {
            payrollRepo.deleteById(id);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return; 
    }


}