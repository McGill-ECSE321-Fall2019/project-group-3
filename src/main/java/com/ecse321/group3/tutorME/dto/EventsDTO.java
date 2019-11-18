package com.ecse321.group3.tutorME.dto;

import com.ecse321.group3.tutorME.domain.Course;
import com.ecse321.group3.tutorME.domain.Room;

public class EventsDTO {

    private Course course;
    private Room room;

    public EventsDTO(Course course, Room room) {
        this.course = course;
        this.room = room;
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
