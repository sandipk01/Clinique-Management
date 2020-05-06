package com.bridgelabz.model;

import java.util.Date;
import java.util.List;

public class Appointment {
    private int id;
    private Date date;
    private int doctorId;
    private List<Patient> patients;
}
