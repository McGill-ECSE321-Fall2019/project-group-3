package com.ecse321.group3.tutorME.domain;

import java.time.LocalDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lessonId;
    
    @Column
    private LocalDate startTime;
    
    @Column
    private LocalDate endTime;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Tutor tutor;

    @ManyToMany
    private List<Student> student;

    public Lesson() {}

    public Lesson(int lessonId, LocalDate startTime, LocalDate endTime, Course course, Room room) {
		super();
		this.lessonId = lessonId;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}
    
}
