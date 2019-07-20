package com.arkdev.courses.models;

public class CourseAttendees {
    private String userID;
    private String courseID;

    public CourseAttendees(String userID, String courseID) {
        this.userID = userID;
        this.courseID = courseID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
