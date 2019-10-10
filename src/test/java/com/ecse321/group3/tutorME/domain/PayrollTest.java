package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.PayrollRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PayrollTest {

    @Autowired
    private PayrollRepository payrollRepo;

    @Test
    public void createPayroll(){
        Tutor tutor1 = new Tutor();
        tutor1.setRate(100);
        Tutor tutor2 = new Tutor();
        tutor2.setRate(50);

        List<Tutor> tutors = new ArrayList<>();
        tutors.add(tutor1);
        tutors.add(tutor2);

        Payroll payroll = new Payroll();
        payroll.setTutors(tutors);

        try{
            payrollRepo.save(payroll);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void readPayroll(){
        createPayroll();
        Assert.assertEquals(1, payrollRepo.findAll().size());
    }
}