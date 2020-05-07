package com.bridgelabz.service;

import com.bridgelabz.model.Patient;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IPatient {

    void addPatient(Patient patient) throws IOException, ClassNotFoundException;

    void printPatient() throws IOException, ClassNotFoundException;

    File getFile();

    List<Patient> searchByName(String name) throws IOException, ClassNotFoundException;

    List<Patient> searchByPhone(String phone) throws IOException, ClassNotFoundException;
}
