package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int schedule_id;

    @OneToOne(mappedBy = "schedule")
    private Tutor tutor;

    @OneToOne(mappedBy = "roomAvailability")
    private Room room;

    @ElementCollection
    @Column
    private List<Date> dateTime;

    public Schedule() {
    }

    public Schedule(int schedule_id, Tutor tutor, Room room) {
        this.schedule_id = schedule_id;
        this.tutor = tutor;
        this.room = room;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Date> getDateTime() {
        return dateTime;
    }

    public void setDateTime(List<Date> dateTime) {
        this.dateTime = dateTime;
    }
}
