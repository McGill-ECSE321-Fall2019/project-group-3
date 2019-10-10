package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tutor extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tutorId;

    @Column
    private int rate;

    @ManyToMany
    @JoinTable(
            name="courses_taught",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name="course_number")
    )
    private List<Course> coursesTaught;

    @OneToMany
    private List<Review> reviewsGiven;

    @OneToMany
    private List<Review> reviewsReceived;

    @OneToOne
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
