package com.bridgelabz.model;

import com.bridgelabz.enums.Availability;

import java.util.Objects;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private Availability availability;

    public Doctor(String name, String specialization, Availability availability) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public long getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id='" + id + " " +
                "name='" + name + " " +
                "specialization='" + specialization + " " +
                "availability=" + availability;
    }

}
