package com.bridgelabz.model;

import com.bridgelabz.enums.Availability;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private Availability availability;

    public Doctor(int id, String name, String specialization, Availability availability) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Availability getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "id='" + id + " " +
                "name='" + name + " " +
                "specialization='" + specialization + " " +
                "availability=" + availability;
    }
}
