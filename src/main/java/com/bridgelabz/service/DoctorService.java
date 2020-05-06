package com.bridgelabz.service;

import com.bridgelabz.model.Doctor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoctorService extends Manage implements IDoctor {

    private File file = new File("src\\test\\resources\\doctor.json");
    private List<Doctor> doctorList;

    @Override
    public void addDoctor(Doctor doctor) throws IOException {
        if (file.length() == 0)
            doctorList = new ArrayList<>();
        else
            doctorList = FileSystem.readFile(file);
        FileSystem.saveFile(file, addEntry(doctorList, doctor));
    }

    @Override
    public void printDoctor() throws IOException {
        doctorList = FileSystem.readFile(file);
        printEntry(doctorList);
    }


}
