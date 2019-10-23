package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Review;
import com.ecse321.group3.tutorME.domain.Student;
import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.domain.UserRole;
import com.ecse321.group3.tutorME.domain.enums.ReviewAuthor;
import com.ecse321.group3.tutorME.repository.ReviewRepository;
import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReviewServiceTests {

    @Autowired
    private TestSuiteUtils testSuiteUtils;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewServiceIF reviewService;

    @Before
    public void init(){
        testSuiteUtils.truncateDatabase();
    }

    @Test
    @Transactional
    public void testGetReviewsForTutor(){
        Tutor tutor1 = new Tutor();

        userRoleRepository.save(tutor1);

        Review review = new Review();
        review.setTutor((Tutor) tutor1);
        review.setReviewAuthor(ReviewAuthor.STUDENT);
        review.setRating(5);
        review.setComment("no one is ever going to read this");

        Review review2 = new Review();
        review2.setTutor(tutor1);
        review2.setReviewAuthor(ReviewAuthor.STUDENT);
        review2.setRating(1);
        review2.setComment("this tutor sucks");

        Review review3 = new Review();
        review3.setTutor(tutor1);
        review3.setReviewAuthor(ReviewAuthor.TUTOR);
        review3.setRating(1);
        review3.setComment("this student sucks");

        reviewRepository.save(review);
        reviewRepository.save(review2);
        reviewRepository.save(review3);

        String tutor_email = userRoleRepository.findAll().get(0).getUser().getEmail();

        List<Review> reviewsForTutor = new ArrayList<>();

        try{
            reviewsForTutor = reviewService.getReviewsForTutor(tutor_email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(2, reviewsForTutor.size());
    }

    @Test
    @Transactional
    public void testGetReviewsForStudent(){
        Tutor tutor1 = new Tutor();
        Student student = new Student();

        userRoleRepository.save(tutor1);
        userRoleRepository.save(student);

        Review review = new Review();
        review.setTutor((Tutor) tutor1);
        review.setStudent(student);
        review.setReviewAuthor(ReviewAuthor.TUTOR);
        review.setRating(5);
        review.setComment("no one is ever going to read this");

        Review review2 = new Review();
        review2.setTutor(tutor1);
        review2.setReviewAuthor(ReviewAuthor.STUDENT);
        review2.setStudent(student);
        review2.setRating(1);
        review2.setComment("this tutor sucks");

        Review review3 = new Review();
        review3.setTutor(tutor1);
        review3.setReviewAuthor(ReviewAuthor.TUTOR);
        review3.setStudent(student);
        review3.setRating(1);
        review3.setComment("this student sucks");

        reviewRepository.save(review);
        reviewRepository.save(review2);
        reviewRepository.save(review3);

        String student_email = userRoleRepository.findAll().get(0).getUser().getEmail();

        List<Review> reviewsForTutor = new ArrayList<>();

        try{
            reviewsForTutor = reviewService.getReviewsForStudent(student_email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(2, reviewsForTutor.size());
    }


}
