package com.tariqtesting;

public class Admin extends Person{
    public final int pin;



    public Admin(String name, String email, String PhoneNumber, int pin) {
        super(name,email,PhoneNumber);
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public String toString() {
        return getName() + " - " + getEmail();
    }
}
