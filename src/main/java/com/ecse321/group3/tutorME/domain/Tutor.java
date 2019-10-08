package com.ecse321.group3.tutorME.domain;

import java.util.List;

public class Tutor extends UserRole {

    private int rate;
    private List<Course> coursesTaught;
    private List<Review> reviewsGiven;
    private List<Review> reviewsReceived;
    private Schedule schedule;

    public Tutor() {}

    public Tutor(int rate, List<Course> coursesTaught, List<Review> reviewsGiven, List<Review> reviewsReceived, Schedule schedule) {
        this.rate = rate;
        this.coursesTaught = coursesTaught;
        this.reviewsGiven = reviewsGiven;
        this.reviewsReceived = reviewsReceived;
        this.schedule = schedule;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public List<Review> getReviewsGiven() {
        return reviewsGiven;
    }

    public void setReviewsGiven(List<Review> reviewsGiven) {
        this.reviewsGiven = reviewsGiven;
    }

    public List<Review> getReviewsReceived() {
        return reviewsReceived;
    }

    public void setReviewsReceived(List<Review> reviewsReceived) {
        this.reviewsReceived = reviewsReceived;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
