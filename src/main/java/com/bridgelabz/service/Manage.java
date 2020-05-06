package com.bridgelabz.service;

import java.util.List;

public class Manage {

    public <T> List<T> addEntry(List<T> list, T obj) {
        list.add(obj);
        return list;
    }

    public <T> void printEntry(List<T> list) {
        list.forEach(s -> System.out.println(s.toString().replace("{", "")
                .replace("}", "").replace(",","  ")));
    }

}
