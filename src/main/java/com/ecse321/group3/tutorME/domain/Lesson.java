package com.ecse321.group3.tutorME.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int lessonId;
    
    @Column
    private LocalDateTime startTime;
    
    @Column
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference(value = "course-lesson")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference(value = "room-lesson")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference(value = "tutor-lesson")
    private Tutor tutor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="lesson_students", joinColumns=@JoinColumn(name="student_email"), inverseJoinColumns=@JoinColumn(name="lessonId"))
    private List<Student> student;

    public Lesson() {}

    public Lesson(int lessonId, LocalDateTime startTime, LocalDateTime endTime, Course course, Room room) {
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
    
}
