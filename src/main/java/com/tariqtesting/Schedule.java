package com.tariqtesting;

import java.io.Serializable;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private String courseName;
    private String instructor;
    private String time;
    private String day;
    private int courseNo;

    public Schedule(String courseName, String instructor, String time, String day,int courseNo) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.time = time;
        this.day = day;
        this.courseNo=courseNo;
    }


    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }

    public int getCourseNo(){
        return courseNo;
    }

    @Override
    public String toString() {
        return courseName + " , " + instructor + " , " + time + " , " + day + " , " + courseNo;
    }
}
