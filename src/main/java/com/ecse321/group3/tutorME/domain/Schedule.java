package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int schedule_id;

    @OneToOne(mappedBy = "schedule")
    private Tutor tutor;

    @Column
    private LocalDate dateTime;

    public Schedule() {
    }

    public Schedule(int scheduleId) {
        this.schedule_id = scheduleId;
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

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }
}
