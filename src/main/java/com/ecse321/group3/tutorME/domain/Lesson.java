package com.ecse321.group3.tutorME.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lessonId;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Tutor tutor;

    @ManyToMany
    private List<Student> student;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    public Lesson() {}

    public Lesson(int lessonId, Course course, Room room, Tutor tutor, List<Student> student, Date startTime, Date endTime) {
        this.lessonId = lessonId;
        this.course = course;
        this.room = room;
        this.tutor = tutor;
        this.student = student;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
