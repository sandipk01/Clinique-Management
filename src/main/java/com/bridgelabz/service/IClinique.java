package com.bridgelabz.service;

import com.bridgelabz.model.Appointment;

import java.io.File;
import java.io.IOException;

public interface IClinique {

    boolean takeAppointment(Appointment appointment) throws IOException, ClassNotFoundException;

    File getFile();

}
