package com.tariqtesting;

import java.io.Serializable;

public class Advisor extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Advisor(String name, String email,String ID,String PhoneNumber) {
        super(name, email,ID,PhoneNumber);
    }


    @Override
    public String toString() {
        return getName() + "  " + getEmail() + "  "+ getID() + "  " + getPhoneNumber();
    }
}


