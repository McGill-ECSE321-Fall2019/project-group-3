package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tutor")
public class Tutor extends UserEntity {

    @Column
    private double rate;

    @ManyToMany
    private List<Course> courses_taught;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToOne
    private Schedule schedule;

    @OneToMany(mappedBy = "tutor")
    private List<Lesson> lesson;

    public Tutor() {}

    public Tutor(double rate, List<Course> courses_taught, List<Review> reviews, Schedule schedule, List<Lesson> lesson) {
        this.rate = rate;
        this.courses_taught = courses_taught;
        this.reviews = reviews;
        this.schedule = schedule;
        this.lesson = lesson;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<Course> getCourses_taught() {
        return courses_taught;
    }

    public void setCourses_taught(List<Course> courses_taught) {
        this.courses_taught = courses_taught;
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

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }
}
