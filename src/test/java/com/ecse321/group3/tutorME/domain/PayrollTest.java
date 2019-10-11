package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.PayrollRepository;
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
public class PayrollTest {

    @Autowired
    private PayrollRepository payrollRepo;
    @Autowired
    private TestSuiteUtils testUtils;
    
    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @Test
    @Transactional
    public void createPayroll(){
        Payroll payroll = new Payroll();

        try{
            payrollRepo.save(payroll);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void readPayroll(){
        createPayroll();
        Assert.assertEquals(1, payrollRepo.findAll().size());
    }
}