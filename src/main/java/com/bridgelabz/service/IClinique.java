package com.bridgelabz.service;

import com.bridgelabz.enums.Availability;
import com.bridgelabz.model.Appointment;

import java.io.File;
import java.io.IOException;

public interface IClinique {

    boolean takeAppointment(Appointment appointment) throws IOException, ClassNotFoundException;

    File getFile();

    boolean checkDate(String date,int doctorId) throws IOException, ClassNotFoundException;

    boolean checkAvailabilityAtPm(String date, int doctorId) throws IOException, ClassNotFoundException;

    boolean checkAvailabilityAtAm(String date, int doctorId) throws IOException, ClassNotFoundException;

    Availability getDoctorAvailabilityById(int doctorId) throws IOException, ClassNotFoundException;
}
