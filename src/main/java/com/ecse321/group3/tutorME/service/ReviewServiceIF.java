package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewServiceIF {

    Review createReview(Review review) throws Exception;
    Review getReview(int review_id) throws Exception;
    List<Review> getReviews() throws Exception;
    void deleteReview(int review_id) throws Exception;

    List<Review> getReviewsForTutor(int tutor_id) throws Exception;
    List<Review> getReviewsForStudent(int student_id) throws Exception;
}
