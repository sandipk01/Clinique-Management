package com.bridgelabz.test;

import com.bridgelabz.enums.Availability;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.*;
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
        Doctor doctor1 = new Doctor("Mangesh", "Dentist", Availability.AM);
        doctorService.addDoctor(doctor1);
        Assert.assertEquals(oldSize + 1, FileSystem.readFile(doctorService.getFile(), Doctor.class).size());
    }

    @Test
    public void givenPatientDetails_WhenAddingToJson_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        int oldSize = (patientService.getFile().length() == 0) ? 0 : FileSystem.readFile(patientService.getFile(), Patient.class).size();
        Patient patient1 = new Patient("roit", "9988568562", 45);
        patientService.addPatient(patient1);
        Assert.assertEquals(oldSize + 1, FileSystem.readFile(patientService.getFile(), Patient.class).size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchByName_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Doctor doctor1 = new Doctor("Mangesh", "heart specialist", Availability.AM);
        Doctor doctor2 = new Doctor("Ramesh", "heart specialist", Availability.PM);
        Doctor doctor3 = new Doctor("Suresh", "brain specialist", Availability.AM);
        doctorService.addDoctor(doctor1);
        doctorService.addDoctor(doctor2);
        doctorService.addDoctor(doctor3);
        Assert.assertEquals(2, doctorService.searchByName("Mangesh").size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchById_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
       Assert.assertEquals(1, doctorService.searchById(2).size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchBySpecialization_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(1, doctorService.searchBySpecialization("brain specialist").size());
    }

    @Test
    public void givenDoctorDetails_WhenSearchByAvailability_ThenShouldReturnTotalEntry() throws IOException, ClassNotFoundException {
        Assert.assertEquals(1, doctorService.searchByAvailability(Availability.PM).size());
    }
}