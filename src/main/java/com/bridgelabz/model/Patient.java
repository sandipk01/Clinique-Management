package com.bridgelabz.model;

public class Patient extends Person {

    private String phone;
    private long age;

    public Patient(String name, int id, String phone, long age) {
        super(name, id);
        this.phone = phone;
        this.age = age;
    }
}
