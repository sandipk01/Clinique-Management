package com.bridgelabz.service;

import com.bridgelabz.enums.Availability;
import com.bridgelabz.exception.CliniqueManagmentException;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.util.FileSystem;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CliniqueService extends Manage implements IClinique {

    private File file = new File("src\\test\\resources\\appointments.json");

    private List<Appointment> appointmentList;

    private IDoctor doctorService;

    public CliniqueService() {
        doctorService = new DoctorService();
    }

    public File getFile() {
        return file;
    }

    @Override
    public boolean takeAppointment(Appointment appointment) throws IOException, ClassNotFoundException, CliniqueManagmentException {
        if (file.length() == 0) {
            if (getDoctorAvailabilityById(appointment.getDoctorId()) == appointment.getAvailability()
                    || getDoctorAvailabilityById(appointment.getDoctorId()) == Availability.BOTH) {
                appointment.setId(1);
                appointmentList = new ArrayList<>();
            } else {
                return false;
            }
        } else {
            appointmentList = FileSystem.readFile(file, Appointment.class);
            if (checkAvailability(appointment)) {
                appointment.setId(appointmentList.size() + 1);
            } else {
                return false;
            }
        }
        FileSystem.saveFile(file, addEntry(appointmentList, appointment));
        return true;
    }

    private boolean checkAvailability(Appointment appointment) throws IOException, ClassNotFoundException, CliniqueManagmentException {
        if (getDoctorAvailabilityById(appointment.getDoctorId()) == appointment.getAvailability()
                || getDoctorAvailabilityById(appointment.getDoctorId()) == Availability.BOTH) {
            if (checkPatientsPerDay(appointment.getDate(), appointment.getDoctorId()))
                return true;
            else
                throw new CliniqueManagmentException("Doctor appointment is full for the day.", CliniqueManagmentException.TypeOfException.APPOINTMENT_FULL);
        } else {
            throw new CliniqueManagmentException("Doctor is not available at this Time", CliniqueManagmentException.TypeOfException.INVALID_AVAILABILITY);
        }
    }

    private boolean checkPatientsPerDay(String date, int doctorId) throws IOException, ClassNotFoundException {
        appointmentList = FileSystem.readFile(file, Appointment.class);
        long count = appointmentList.stream()
                .filter(d -> d.getDate().equals(date) && d.getDoctorId() == doctorId)
                .count();
        return (count >= 5) ? false : true;
    }

    private Availability getDoctorAvailabilityById(int doctorId) throws IOException, ClassNotFoundException {
        List<Doctor> doctorList = FileSystem.readFile(doctorService.getFile(), Doctor.class);
        Doctor doctor = doctorList.stream()
                .filter((doctor1) -> doctor1.getId() == doctorId).findFirst().get();
        return doctor.getAvailability();
    }
}



