package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lessonId;

    @ManyToOne
    private Course course;

    @OneToOne
    private Room room;

    public Lesson() {}

    public Lesson(int lessonId, Course course, Room room) {
        this.lessonId = lessonId;
        this.course = course;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
