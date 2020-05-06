package com.bridgelabz.service;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;

import java.io.File;
import java.io.IOException;

public interface IPatient {

    void addPatient(Patient patient) throws IOException, ClassNotFoundException;

    void printPatient() throws IOException, ClassNotFoundException;

    File getFile();
}
