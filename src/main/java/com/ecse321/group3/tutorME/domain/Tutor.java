package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name="tutor")
public class Tutor extends UserEntity {

    @Column
    private double rate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="tutor_courses_approved", joinColumns=@JoinColumn(name="tutor_email"), inverseJoinColumns=@JoinColumn(name="course_name"))
    private List<Course> courses_taught;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    @JsonManagedReference(value="tutor-review")
    private List<Review> reviews;

    @OneToOne
    private Schedule schedule;

    @OneToMany(mappedBy = "tutor")
    @JsonManagedReference(value = "tutor-lesson")
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
