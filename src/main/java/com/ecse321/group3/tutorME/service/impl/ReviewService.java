package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Review;
import com.ecse321.group3.tutorME.domain.Student;
import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.domain.UserRole;
import com.ecse321.group3.tutorME.domain.enums.ReviewAuthor;
import com.ecse321.group3.tutorME.repository.ReviewRepository;
import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import com.ecse321.group3.tutorME.service.ReviewServiceIF;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements ReviewServiceIF {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private UserRoleRepository userRoleRepo;

    @Override
    public Review createReview(Review review) throws Exception {
        Review reviewCreated = null;

        try {
            reviewCreated = reviewRepo.save(review);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return reviewCreated;
    }

    @Override
    public Review getReview(int review_id) throws Exception {
        Review review = null;

        try{
            review = reviewRepo.getOne(review_id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return  review;
    }

    @Override
    public List<Review> getReviews() throws Exception {
        List<Review> reviews = null;

        try{
            reviews = reviewRepo.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return reviews;
    }

    @Override
    public void deleteReview(int review_id) throws Exception {
        try{
            reviewRepo.deleteById(review_id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Review> getReviewsForTutor(int tutor_id) throws Exception {
        List<Review> reviews = new ArrayList<>();
        UserRole tutor =  userRoleRepo.getOne(tutor_id);

        try{
            reviews = reviewRepo.findByTutorAndReviewAuthor(tutor, ReviewAuthor.STUDENT);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return reviews;
    }

    @Override
    public List<Review> getReviewsForStudent(int student_id) throws Exception {
        List<Review> reviews = null;
        UserRole student = userRoleRepo.getOne(student_id);
        try{
            reviews = reviewRepo.findByStudentAndReviewAuthor(student, ReviewAuthor.TUTOR);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return reviews;
    }
}
