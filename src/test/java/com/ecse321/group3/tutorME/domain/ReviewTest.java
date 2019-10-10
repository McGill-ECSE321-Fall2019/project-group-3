package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.ReviewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewTest {

    @Autowired
    private ReviewRepository reviewRepo;

    @Test
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
    public void readReview(){
        saveReview();
        Assert.assertEquals(1, reviewRepo.findAll().size());
    }
}
