package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Review;
import com.ecse321.group3.tutorME.service.ReviewServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewServiceIF reviewService;

    @RequestMapping(value = "/api/review", method = POST)
    public ResponseEntity<Review> createReview(@RequestBody Review review){

        if(review == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Review createdReview = null;

        try{
            createdReview = reviewService.createReview(review);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdReview, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/review", method = GET)
    public ResponseEntity<Review> getReview(@RequestParam int review_id){

        Review review = null;

        try{
            review = reviewService.getReview(review_id);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/review/getall", method = GET)
    public ResponseEntity<List<Review>> getReviews(){
        List<Review> reviews = null;

        try{
            reviews = reviewService.getReviews();
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/review/update", method = POST)
    public ResponseEntity<Review> updateReview(@RequestParam int review_id, @RequestBody Review review){

        if(review_id <= 0 || review == null || review.getReview_id() <= 0)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        Review updatedReview = null;

        try{
            updatedReview = reviewService.updateReview(review_id, review);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/review", method = DELETE)
    public ResponseEntity<Review> deleteReview(@RequestParam int review_id){

        try{
            reviewService.deleteReview(review_id);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/review/getForTutor", method = GET)
    public ResponseEntity<List<Review>> getReviewsForTutor(@RequestParam String tutor_email){
        List<Review> reviews = null;

        try{
            reviews = reviewService.getReviewsForTutor(tutor_email);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/review/getForStudent", method = GET)
    public ResponseEntity<List<Review>> getReviewsForStudent(@RequestParam String student_email){
        List<Review> reviews = null;

        try{
            reviews = reviewService.getReviewsForStudent(student_email);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
