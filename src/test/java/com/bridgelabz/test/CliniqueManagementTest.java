package com.bridgelabz.test;

import com.bridgelabz.enums.Availability;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.*;
import com.bridgelabz.util.FileSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CliniqueManagementTest {

    private IDoctor doctorService;
    private IPatient patientService;

    @Before
    public void setUP() {
        doctorService = new DoctorService();
        patientService = new PatientService();
    }

    @Test
    public void givenDoctorDetails_WhenAddingToJson_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        int oldSize = (doctorService.getFile().length() == 0) ? 0 : FileSystem.readFile(doctorService.getFile(), Doctor.class).size();
        Doctor doctor1 = new Doctor("Mangesh", "heart specialist", Availability.AM);
        Doctor doctor2 = new Doctor("Ramesh", "heart specialist", Availability.PM);
        Doctor doctor3 = new Doctor("Suresh", "brain specialist", Availability.AM);
        Doctor doctor4 = new Doctor("Mangesh", "Dentist", Availability.AM);
        doctorService.addDoctor(doctor1);
        doctorService.addDoctor(doctor2);
        doctorService.addDoctor(doctor3);
        doctorService.addDoctor(doctor4);
        Assert.assertEquals(oldSize + 4, FileSystem.readFile(doctorService.getFile(), Doctor.class).size());
    }

    @Test
    public void givenPatientDetails_WhenAddingToJson_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        int oldSize = (patientService.getFile().length() == 0) ? 0 : FileSystem.readFile(patientService.getFile(), Patient.class).size();
        Patient patient1 = new Patient("mahesh", "9988568562", 45);
        Patient patient2 = new Patient("jhon", "5888568562", 50);
        Patient patient3 = new Patient("mahesh", "6188568562", 55);
        Patient patient4 = new Patient("swati", "5588568562", 34);
        Patient patient5 = new Patient("jyoti", "9988778562", 29);
        patientService.addPatient(patient1);
        patientService.addPatient(patient2);
        patientService.addPatient(patient3);
        patientService.addPatient(patient4);
        patientService.addPatient(patient5);
        Assert.assertEquals(oldSize + 5, FileSystem.readFile(patientService.getFile(), Patient.class).size());
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
        Assert.assertEquals(2, patientService.searchByName("mahesh").size());
    }

    @Test
    public void givenPatientDetails_WhenSearchByPhone_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(1, patientService.searchByPhone("6188568562").size());
    }
}