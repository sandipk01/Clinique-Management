package com.bridgelabz.service;

import com.bridgelabz.model.Doctor;

import java.io.IOException;

public interface IDoctor {

    void addDoctor(Doctor doctor) throws IOException;

    void printDoctor() throws IOException;
}
