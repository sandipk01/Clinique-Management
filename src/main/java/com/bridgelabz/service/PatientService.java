package com.bridgelabz.service;

import com.bridgelabz.model.Patient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientService extends Manage implements IPatient {

    private File file = new File("src\\test\\resources\\patient.json");

    private List<Patient> patientList;

    @Override
    public void addPatient(Patient patient) throws IOException, ClassNotFoundException {
        if (file.length() == 0) {
            patient.setId(1);
            patientList = new ArrayList<>();
        } else {
            patientList = FileSystem.readFile(file, Patient.class);
            patient.setId(patientList.size() + 1);
        }
        FileSystem.saveFile(file, addEntry(patientList, patient));
    }

    @Override
    public void printPatient() throws IOException, ClassNotFoundException {
        patientList = FileSystem.readFile(file, Patient.class);
        printEntry(patientList);
    }

    @Override
    public File getFile() {
        return file;
    }
}
