package com.bridgelabz.test;

import com.bridgelabz.enums.Availability;
import com.bridgelabz.exception.CliniqueManagmentException;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.*;
import com.bridgelabz.util.FileSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CliniqueManagementTest {

    private IDoctor doctorService;
    private IPatient patientService;
    private IClinique cliniqueService;

    @Before
    public void setUP() {
        doctorService = new DoctorService();
        patientService = new PatientService();
        cliniqueService = new CliniqueService();
    }

    @Test
    public void givenDoctorDetails_WhenAddingToJson_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        int oldSize = (doctorService.getFile().length() == 0) ? 0 : FileSystem.readFile(doctorService.getFile(), Doctor.class).size();
        Doctor doctor1 = new Doctor("Mangesh", "heart specialist", Availability.AM);
        Doctor doctor2 = new Doctor("Ramesh", "heart specialist", Availability.BOTH);
        Doctor doctor3 = new Doctor("Suresh", "brain specialist", Availability.AM);
        Doctor doctor4 = new Doctor("Mangesh", "Dentist", Availability.AM);
        Doctor doctor5 = new Doctor("Rohit", "Dentist", Availability.PM);
        doctorService.addDoctor(doctor1);
        doctorService.addDoctor(doctor2);
        doctorService.addDoctor(doctor3);
        doctorService.addDoctor(doctor4);
        doctorService.addDoctor(doctor5);
        Assert.assertEquals(oldSize + 5, FileSystem.readFile(doctorService.getFile(), Doctor.class).size());
    }

    @Test
    public void givenPatientDetails_WhenAddingToJson_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        int oldSize = (patientService.getFile().length() == 0) ? 0 : FileSystem.readFile(patientService.getFile(), Patient.class).size();
        Patient patient1 = new Patient("mahesh", "9988568562", 45);
        Patient patient2 = new Patient("jhon", "5888568562", 50);
        Patient patient3 = new Patient("mahesh", "6188568562", 55);
        Patient patient4 = new Patient("swati", "5588568562", 34);
        Patient patient5 = new Patient("jyoti", "9988778562", 29);
        Patient patient6 = new Patient("mahesh", "7784512458", 45);
        Patient patient7 = new Patient("jhon", "5888568562", 50);
        Patient patient8 = new Patient("mahesh", "6188568562", 55);
        Patient patient9 = new Patient("swati", "5588568562", 34);
        Patient patient10 = new Patient("jyoti", "9988778562", 29);
        Patient patient11 = new Patient("mahesh", "9988568562", 45);
        patientService.addPatient(patient1);
        patientService.addPatient(patient2);
        patientService.addPatient(patient3);
        patientService.addPatient(patient4);
        patientService.addPatient(patient5);
        patientService.addPatient(patient6);
        patientService.addPatient(patient7);
        patientService.addPatient(patient8);
        patientService.addPatient(patient9);
        patientService.addPatient(patient10);
        patientService.addPatient(patient11);
        Assert.assertEquals(oldSize + 11, FileSystem.readFile(patientService.getFile(), Patient.class).size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchByName_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(2, doctorService.searchByName("Mangesh").size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchById_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(1, doctorService.searchById(2).size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchBySpecialization_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(2, doctorService.searchBySpecialization("heart specialist").size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchByAvailability_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(1, doctorService.searchByAvailability(Availability.PM).size());
    }

    @Test
    public void givenPatientDetails_WhenSearchByName_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(5, patientService.searchByName("mahesh").size());
    }

    @Test
    public void givenPatientDetails_WhenSearchByPhone_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(1, patientService.searchByPhone("7784512458").size());
    }

    @Test
    public void givenPatientDetails_WhenSearchByID_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(1, patientService.searchById(3).size());
    }

    @Test
    public void givenAppointmentDetails_WhenTakeAppointment_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException, CliniqueManagmentException {
        Appointment appointment1 = new Appointment("9-5-20", 1, 1, Availability.AM);
        Appointment appointment2 = new Appointment("9-5-20", 1, 5, Availability.AM);
        Appointment appointment3 = new Appointment("9-5-20", 1, 1, Availability.AM);
        cliniqueService.takeAppointment(appointment1);
        cliniqueService.takeAppointment(appointment2);
        cliniqueService.takeAppointment(appointment3);
        List<Appointment> appointmentsList = FileSystem.readFile(cliniqueService.getFile(), Appointment.class);
        Assert.assertEquals(3, appointmentsList.size());
    }

    @Test
    public void givenAppointmentDetails_WhenAvailabilityIsWrong_ThenShouldThrowInvalidAvailabilityException() throws IOException, ClassNotFoundException {
        try {
            Appointment appointment1 = new Appointment("9-5-20", 1, 1, Availability.AM);
            Appointment appointment2 = new Appointment("9-5-20", 1, 5, Availability.AM);
            Appointment appointment3 = new Appointment("9-5-20", 1, 1, Availability.PM);
            cliniqueService.takeAppointment(appointment1);
            cliniqueService.takeAppointment(appointment2);
            cliniqueService.takeAppointment(appointment3);
        } catch (CliniqueManagmentException e) {
            Assert.assertEquals(CliniqueManagmentException.TypeOfException.INVALID_AVAILABILITY, e.type);
        }
    }

    @Test
    public void givenAppointmentDetails_WhenAvailabilityFull_ThenShouldThrowAppointmentFullException() throws IOException, ClassNotFoundException {
        try {
            Appointment appointment1 = new Appointment("9-5-20", 1, 1, Availability.AM);
            cliniqueService.takeAppointment(appointment1);
        } catch (CliniqueManagmentException e) {
            Assert.assertEquals(CliniqueManagmentException.TypeOfException.APPOINTMENT_FULL, e.type);
        }
    }

}