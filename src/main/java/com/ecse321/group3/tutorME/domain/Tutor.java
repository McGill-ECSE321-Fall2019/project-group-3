package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tutor")
public class Tutor extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tutor_id;

    @Column
    private int rate;

    @ManyToMany
    private List<Course> courses_taught;

    @OneToMany(mappedBy = "tutor")
    private List<Review> reviews;

    @OneToOne
    private Schedule schedule;

    public Tutor() {}

    public Tutor(int tutor_id, int rate, List<Course> courses_taught, List<Review> reviews, Schedule schedule) {
        this.tutor_id = tutor_id;
        this.rate = rate;
        this.courses_taught = courses_taught;
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
}
