package com.bridgelabz.service;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CliniqueManage {

    public static <T> List<T> addEntry(List<T> list, T obj) {
        list.add(obj);
        return list;
    }

    public static <T> void printEntry(List<T> list) {
        list.forEach(s -> System.out.println());
    }

    public static <T> List<T> searchEntry(Collection<T> collectionObject,
                                     Function<T, String> searchPropertyAccessor, String searchText) {
        List<T> result = collectionObject.stream()
                .filter(item -> Objects.equals(searchPropertyAccessor.apply(item), searchText))
                .collect(Collectors.toList());
        return result;
    }
}
