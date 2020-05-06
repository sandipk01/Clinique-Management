package com.bridgelabz.model;

public class Patient {
    private int id;
    private String name;
    private String phone;
    private long age;

    public Patient(int id, String name, String phone, long age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
