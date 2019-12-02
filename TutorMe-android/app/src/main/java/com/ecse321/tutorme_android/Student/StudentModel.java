package com.ecse321.tutorme_android.Student;

import java.util.List;

public class StudentModel {

    private String firstName;
    private String lastName;
    private String email;
    private List<String> reviewComments;

    public StudentModel(String firstName,String lastName, String email, List<String> reviewComments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.reviewComments = reviewComments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public List<String> getReviewComments() {
        return reviewComments;
    }

}
