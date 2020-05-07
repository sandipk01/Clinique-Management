package com.bridgelabz.service;

import com.bridgelabz.model.Doctor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IDoctor {

    void addDoctor(Doctor doctor) throws IOException, ClassNotFoundException;

    void printDoctor() throws IOException, ClassNotFoundException;

    File getFile();

    List<Doctor> searchByName(String name) throws IOException, ClassNotFoundException;
}
