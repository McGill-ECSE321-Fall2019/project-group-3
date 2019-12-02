package com.ecse321.tutorme_android.Course.model;

import java.util.List;

/*
This is a sample class to hold data for the Subject
-- Holds a title, and a list of associated courses' names.
 */
public class CourseModel {

    private String subjectTitle;
    private List<String> courseNames;

    /**
     * Create a Course Model with subjbect title, and a list of the courses available.
     * @param subjectTitle
     * @param courseNames
     */
    public CourseModel(String subjectTitle, List<String> courseNames) {
        this.subjectTitle = subjectTitle;
        this.courseNames = courseNames;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public List<String> getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(List<String> courseNames) {
        this.courseNames = courseNames;
    }
}
