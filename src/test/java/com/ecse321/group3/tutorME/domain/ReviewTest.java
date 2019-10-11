package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.ReviewRepository;
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
public class ReviewTest {

    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private TestSuiteUtils testUtils;
    
    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @Test
    @Transactional
    public void saveReview(){
        Review review1 = new Review();
        review1.setRating(4);
        review1.setComment("Hello this is my comment");

        try {
            reviewRepo.save(review1);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void readReview(){
        saveReview();
        Assert.assertEquals(1, reviewRepo.findAll().size());
    }
}
