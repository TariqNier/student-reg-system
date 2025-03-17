package com.tariqtesting;

import java.io.Serializable;


public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private Advisor advisor;
    private String grade;
    protected String birthdate;

    public Student(String name, String email, String ID,String PhoneNumber, String birthdate,Advisor advisor,String grade) {
        super(name, email,ID,PhoneNumber);
        this.birthdate = birthdate;
        this.advisor = advisor;
        this.grade=grade;
    }

    public Student(Student s) {
        super(s.getName(), s.getEmail(), s.getID(), s.getPhoneNumber());
        this.birthdate = s.birthdate;
        this.advisor = s.advisor;
        this.grade = s.grade;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public String getGrade() {
        return grade;
    }

    public String getBirthdate(){
        return birthdate;
    }


    @Override
    public String toString() {
        return getName() + "," + getEmail() + "," + getBirthdate() + "," + getAdvisor() + "," + getGrade() + "," + getID();
    }


}
