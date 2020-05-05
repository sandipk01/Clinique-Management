package com.bridgelabz.model;

import com.bridgelabz.enums.Availability;

public class Doctor extends Person {

    private String specialization;
    private Availability availability;

    public Doctor(String name, int id, String specialization, Availability availability) {
        super(name, id);
        this.specialization = specialization;
        this.availability = availability;
    }

}
