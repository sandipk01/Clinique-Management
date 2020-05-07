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
    public void addDoctor(Doctor doctor) throws IOException, ClassNotFoundException {
        if (file.length() == 0) {
            doctor.setId(1);
            doctorList = new ArrayList<>();
        } else {
            doctorList = FileSystem.readFile(file, Doctor.class);
            doctor.setId(doctorList.size() + 1);
        }
        FileSystem.saveFile(file, addEntry(doctorList, doctor));
    }

    @Override
    public void printDoctor() throws IOException, ClassNotFoundException {
        doctorList = FileSystem.readFile(file, Doctor.class);
        printEntry(doctorList);
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public List<Doctor> searchByName(String name) throws IOException, ClassNotFoundException {
        doctorList = FileSystem.readFile(file, Doctor.class);
        List<Doctor> searchList = search(doctorList, Doctor::getName, name);
        return searchList;
    }

}
