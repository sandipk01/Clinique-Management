package com.bridgelabz.model;

public class Patient {
    private int id;
    private String name;
    private String phone;
    private long age;

    public Patient(){

    }

    public Patient(int id, String name, String phone, long age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public long getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
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
