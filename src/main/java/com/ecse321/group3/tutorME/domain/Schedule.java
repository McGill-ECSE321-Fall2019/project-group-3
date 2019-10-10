package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scheduleId;

    @OneToOne
    private Tutor tutor;

    public Schedule() {
    }

    public Schedule(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
}
