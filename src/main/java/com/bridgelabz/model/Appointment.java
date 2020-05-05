package com.bridgelabz.model;

import java.util.ArrayList;
import java.util.Date;

public class Appointment {
    private int doctorId;
    private Date date;
    private ArrayList<Integer> patientIds = new ArrayList<>();
}
