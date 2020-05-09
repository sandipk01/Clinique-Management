package com.bridgelabz.service;

import com.bridgelabz.exception.CliniqueManagmentException;
import com.bridgelabz.model.Appointment;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IClinique {

    boolean takeAppointment(Appointment appointment) throws IOException, ClassNotFoundException, CliniqueManagmentException;

    File getFile();

    void printReport(int doctorId) throws IOException, ClassNotFoundException;

    int getMostPopularDoctor() throws IOException, ClassNotFoundException;

    String getMostPopularSpecialization()throws IOException, ClassNotFoundException;
}
