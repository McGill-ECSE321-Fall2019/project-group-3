package com.ecse321.tutorme_android.Course.model;

import java.util.List;

/*
This is a sample class to hold data for the University
-- Holds a title, and a list of associated subjects' names. 
 */
public class CourseModel {

    private String courseTitle;
    private List<String> subjectNames;

    /**
     * Create a Course Model with title, and a list of the subjects available.
     * @param courseTitle
     * @param subjectNames
     */
    public CourseModel(String courseTitle, List<String> subjectNames) {
        this.courseTitle = courseTitle;
        this.subjectNames = subjectNames;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public List<String> getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(List<String> subjectNames) {
        this.subjectNames = subjectNames;
    }
}
