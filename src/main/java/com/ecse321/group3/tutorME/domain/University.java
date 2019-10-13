package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="university")
public class University {

    @Id
    @GeneratedValue
    private int university_id;
    
    @Column
    private String university_name;

    @ManyToMany
    private List<Subject> subjects;

    public University() {}

    

    public University(int university_id, String university_name, List<Subject> subjects) {
		super();
		this.university_id = university_id;
		this.university_name = university_name;
		this.subjects = subjects;
	}



	public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }



	public String getUniversity_name() {
		return university_name;
	}



	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
    
}
