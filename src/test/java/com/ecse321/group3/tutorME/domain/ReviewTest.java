package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.ReviewAuthor;
import com.ecse321.group3.tutorME.repository.ReviewRepository;
import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import com.ecse321.group3.tutorME.service.impl.ReviewService;
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
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReviewTest {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private TestSuiteUtils testUtils;

    @Autowired
    private UserEntityRepository userRoleRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;


    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @Test
    @Transactional
    public void saveReview(){
        Review review1 = new Review();
        review1.setReview_id(1);
        review1.setRating(4);
        review1.setComment("Hello this is my comment");

        try {
            reviewService.createReview(review1);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void readReview(){
        saveReview();
        try {
            Assert.assertEquals(1, reviewService.getReview(1).getReview_id());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void deleteReview() throws Exception{
        saveReview();
        reviewService.deleteReview(reviewService.getReviews().get(0).getReview_id());
        Assert.assertEquals(0, reviewService.getReviews().size());
    }

    @Test
    @Transactional
    public void updateReview() throws Exception {
        saveReview();

        Review newReview = new Review();
        newReview.setReview_id(2);

        Assert.assertEquals(1, reviewService.getReviews().size());

        reviewService.updateReview(reviewService.getReviews().get(0).getReview_id(), newReview);

        Assert.assertEquals(1, reviewService.getReviews().size());
    }

    @Test
    @Transactional
    public void getAllReviews() throws Exception{
        saveReview();
        Review newReview = new Review();
        newReview.setReview_id(2);
        reviewService.createReview(newReview);

        Assert.assertEquals(2, reviewService.getReviews().size());
    }

//    @Test
//    @Transactional
//    public void testGetReviewsForTutor(){
//        UserEntity userEntity = new Tutor();
//        userEntity.setEmail("anotherEmailAt@email.com");
//
//        Tutor tutor1 = new Tutor();
//
//
//        Review review = new Review();
//        review.setTutor(tutor1);
//        review.setReviewAuthor(ReviewAuthor.STUDENT);
//        review.setRating(5);
//        review.setComment("no one is ever going to read this");
//
//        tutor1.setReviews(new ArrayList<Review>(Arrays.asList(review)));
//
//        userRoleRepository.save(tutor1);
//
//        String tutor_email = userEntity.getEmail();
//
//        List<Review> reviewsForTutor = new ArrayList<>();
//
//        try{
//            reviewsForTutor = reviewService.getReviewsForTutor(tutor_email);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertEquals(1, reviewsForTutor.size());
//    }
//
//    @Test
//    @Transactional
//    public void testGetReviewsForStudent(){
//        UserEntity userEntity = new UserEntity();
//        userEntity.setEmail("anotherEmailAt@email.com");
//
//        Student student = new Student();
//        userEntity.setUserRole(student);
//        student.setUser(userEntity);
//
//        Review review = new Review();
//        review.setStudent(student);
//        review.setReviewAuthor(ReviewAuthor.TUTOR);
//        review.setRating(5);
//        review.setComment("nthis");
//
//        student.setReview(new ArrayList<Review>(Arrays.asList(review)));
//
//        userRoleRepository.save(student);
//
//        String student_email = userEntity.getEmail();
//
//        List<Review> reviewsForStudent = new ArrayList<>();
//
//        try{
//            reviewsForStudent = reviewService.getReviewsForStudent(student_email);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertEquals(1, reviewsForStudent.size());
//    }
}
