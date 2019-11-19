package com.ecse321.group3.tutorME.domain;


import com.ecse321.group3.tutorME.repository.PayrollRepository;
import com.ecse321.group3.tutorME.service.PayrollServiceIF;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.junit.After;
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
    private PayrollServiceIF payrollService;

    @Autowired
    private TestSuiteUtils testUtils;

    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @After
    public void clean(){testUtils.truncateDatabase();}

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
    public void getAllPayrolls() throws Exception{
        createPayroll();
        Payroll newPayroll = new Payroll();
        payrollService.createPayroll(newPayroll);

        Assert.assertEquals(2, payrollService.getPayrolls().size());
    }
}
