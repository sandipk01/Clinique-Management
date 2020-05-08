package com.bridgelabz.service;

import com.bridgelabz.enums.Availability;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.util.FileSystem;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean takeAppointment(Appointment appointment) throws IOException, ClassNotFoundException {
        if (file.length() == 0) {
            appointment.setId(1);
            appointmentList = new ArrayList<>();
            FileSystem.saveFile(file, addEntry(appointmentList, appointment));
            return true;
        } else {
            appointmentList = FileSystem.readFile(file, Appointment.class);
            if (checkDate(appointment.getDate(), appointment.getDoctorId())) {
                appointment.setId(appointmentList.size() + 1);
                if (appointment.getAvailability() == Availability.AM) {
                    if (checkAvailabilityAtAm(appointment.getDate(), appointment.getDoctorId()))
                        appointment.setAvailability(Availability.AM);
                    else
                        appointment.setAvailability(Availability.PM);
                } else {
                    if (checkAvailabilityAtPm(appointment.getDate(), appointment.getDoctorId()))
                        appointment.setAvailability(Availability.PM);
                    else
                        appointment.setAvailability(Availability.AM);
                }
                FileSystem.saveFile(file, addEntry(appointmentList, appointment));
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public boolean checkDate(String date, int doctorId) throws IOException, ClassNotFoundException {
        appointmentList = FileSystem.readFile(file, Appointment.class);
        Availability availability = getDoctorAvailabilityById(doctorId);
        long count = appointmentList.stream()
                .filter(d -> d.getDate().equals(date) && d.getDoctorId() == doctorId && availability != Availability.BOTH)
                .count();
        long count1 = appointmentList.stream()
                .filter(d -> d.getDate().equals(date) && d.getDoctorId() == doctorId && availability == Availability.BOTH)
                .count();
        return (count >= 5 || count1 >= 10) ? false : true;
    }

    @Override
    public boolean checkAvailabilityAtAm(String date, int doctorId) throws IOException, ClassNotFoundException {
        appointmentList = FileSystem.readFile(file, Appointment.class);
        Availability availability = getDoctorAvailabilityById(doctorId);
        long count = appointmentList.stream()
                .filter(d -> d.getDate().equals(date) && d.getDoctorId() == doctorId && availability == Availability.BOTH && d.getAvailability() == Availability.AM)
                .count();
        return (count >= 5) ? false : true;
    }

    @Override
    public boolean checkAvailabilityAtPm(String date, int doctorId) throws IOException, ClassNotFoundException {
        appointmentList = FileSystem.readFile(file, Appointment.class);
        Availability availability = getDoctorAvailabilityById(doctorId);
        long count = appointmentList.stream()
                .filter(d -> d.getDate().equals(date) && d.getDoctorId() == doctorId && availability == Availability.BOTH && d.getAvailability() == Availability.AM)
                .count();
        return (count >= 5) ? false : true;
    }

    @Override
    public Availability getDoctorAvailabilityById(int doctorId) throws IOException, ClassNotFoundException {
        List<Doctor> doctorList = FileSystem.readFile(doctorService.getFile(), Doctor.class);
        Doctor doctor = doctorList.stream()
                .filter((doctor1) -> doctor1.getId() == doctorId).findFirst().get();
        return doctor.getAvailability();
    }

    public void setAppointmentDate(Appointment appointment, String date) {
        appointment.setDate(date);
    }


}



