package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tutor extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tutor_id;

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
    private List<Review> reviews;

    @OneToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "tutor_id")
    private Schedule schedule;

    public Tutor() {}

    public Tutor(int tutor_id, int rate, List<Course> coursesTaught, List<Review> reviews, Schedule schedule) {
        this.tutor_id = tutor_id;
        this.rate = rate;
        this.coursesTaught = coursesTaught;
        this.reviews = reviews;
        this.schedule = schedule;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
