package com.ecse321.tutorme_android.University.model;

import java.util.List;

public class UniModel {

    private String universityTitle;
    private List<String> subjectNames;

    public UniModel(String universityTitle, List<String> subjectNames) {
        this.universityTitle = universityTitle;
        this.subjectNames = subjectNames;
    }

    public String getUniversityTitle() {
        return universityTitle;
    }

    public void setUniversityTitle(String universityTitle) {
        this.universityTitle = universityTitle;
    }

    public List<String> getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(List<String> subjectNames) {
        this.subjectNames = subjectNames;
    }
}
