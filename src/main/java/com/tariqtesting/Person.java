package com.tariqtesting;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String name;
    protected String email;
    protected String ID;
    protected String PhoneNumber;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(String name, String email,String PhoneNumber) {
        this.name = name;
        this.email = email;
        this.PhoneNumber=PhoneNumber;
    }



    public Person(String name, String email,String ID,String PhoneNumber) {
        this.name = name;
        this.email = email;
        this.PhoneNumber=PhoneNumber;
        this.ID=ID;

    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getID(){
        return ID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    @Override
    public String toString() {
        return name + " ," + email + "," + "," + ID;
    }
}

