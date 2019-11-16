package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Review;
import com.ecse321.group3.tutorME.domain.UserRole;
import com.ecse321.group3.tutorME.domain.enums.ReviewAuthor;
import com.ecse321.group3.tutorME.repository.ReviewRepository;
import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import com.ecse321.group3.tutorME.service.ReviewServiceIF;
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
            review = reviewRepo.findById(review_id).get();
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
    public Review updateReview(int review_id, Review review) throws Exception{
        Review updatedReview = null;

        try{
            deleteReview(review_id);
            updatedReview = createReview(review);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return updatedReview;
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
    public List<Review> getReviewsForTutor(String tutor_email) throws Exception {
        List<Review> reviews = new ArrayList<>();
        UserRole tutor =  userRoleRepo.findByUserEmail(tutor_email);

        try{
            reviews = reviewRepo.findByTutorAndReviewAuthor(tutor, ReviewAuthor.STUDENT);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return reviews;
    }

    @Override
    public List<Review> getReviewsForStudent(String student_email) throws Exception {
        List<Review> reviews = null;
        UserRole student = userRoleRepo.findByUserEmail(student_email);
        try{
            reviews = reviewRepo.findByStudentAndReviewAuthor(student, ReviewAuthor.TUTOR);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return reviews;
    }
}
