package com.ecse321.tutorme_android.Tutor;

import java.util.List;

public class TutorModel {

    private String firstName;
    private String lastName;
    private String email;
    private List<String> reviewComments;

    public TutorModel(String firstName,String lastName, String email, List<String> reviewComments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.reviewComments = reviewComments;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(List<String> reviewComments) {
        this.reviewComments = reviewComments;
    }

}
