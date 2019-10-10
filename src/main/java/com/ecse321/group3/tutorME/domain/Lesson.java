package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lessonId;

    @OneToOne
    private Course course;

    public Lesson() {}

    public Lesson(int lessonId, Course course) {
        this.lessonId = lessonId;
        this.course = course;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
