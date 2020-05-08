package com.bridgelabz.model;

import com.bridgelabz.enums.Availability;


public class Appointment {
    private int id;
    private String date;
    private int doctorId;
    private int patientId;
    private Availability availability;

    public Appointment() {

    }

    public Appointment(String date, int doctorId, int patientId, Availability availability) {
        this.date = date;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", date=" + date +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", Availability= " + availability;
    }
}
