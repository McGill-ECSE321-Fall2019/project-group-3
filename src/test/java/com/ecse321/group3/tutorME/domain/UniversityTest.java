package com.ecse321.group3.tutorME.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ecse321.group3.tutorME.repository.UniversityRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UniversityTest {
	
	@Autowired
    private UniversityRepository universityRepo;
	@Autowired
    private TestSuiteUtils testUtils;
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
	@Transactional
    public void createUniversity(){
        University uni = new University();
        uni.setUniversity_name("McGill");

        try{
            universityRepo.save(uni);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getUniversity(){
        createUniversity();
        Assert.assertEquals(1, universityRepo.findAll().size());
    }
}
