package com.ecse321.tutorme_android.University.model;

import java.util.List;

/*
This is a sample class to hold data for the University
-- Holds a title, and a list of associated subjects' names. 
 */
public class UniModel {

    private String universityTitle;
    private List<String> subjectNames;

    /**
     * Create a University Model with title, and a list of its subject names.
     * @param universityTitle
     * @param subjectNames
     */
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
