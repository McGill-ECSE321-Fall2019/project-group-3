package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
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
}
