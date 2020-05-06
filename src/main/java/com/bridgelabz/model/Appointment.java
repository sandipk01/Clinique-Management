package com.bridgelabz.model;

import java.util.Date;
import java.util.List;

public class Appointment {
    private int id;
    private int doctorId;
    private Date date;
    private List<Patient> patients;
}
