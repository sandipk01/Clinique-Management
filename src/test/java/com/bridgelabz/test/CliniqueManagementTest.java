package com.bridgelabz.test;

import com.bridgelabz.enums.Availability;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.service.FileSystem;
import com.bridgelabz.service.IDoctor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CliniqueManagementTest {

    private IDoctor doctorService;

    @Before
    public void setUP() {
        doctorService = new DoctorService();
    }

    @Test
    public void givenDoctorDetails_WhenAddingToJson_ThenShouldReturnTotalEntry() throws IOException {
        int oldSize = (doctorService.getFile().length() == 0) ? 0 : FileSystem.readFile(doctorService.getFile()).size();
        Doctor doctor1 = new Doctor("Mangesh", "Dentist", Availability.AM);
        doctorService.addDoctor(doctor1);
        Assert.assertEquals(oldSize + 1, FileSystem.readFile(doctorService.getFile()).size());
    }
}
