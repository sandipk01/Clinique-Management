package com.bridgelabz.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Manage {

    public <T> List<T> addEntry(List<T> list, T obj) {
        list.add(obj);
        return list;
    }

    public <T> void printEntry(List<T> list) {
        list.forEach(s -> System.out.println(s.toString().replace("{", "")
                .replace("}", "").replace(",", "  ")));
    }

    public <T, E> List<T> search(Collection<T> collectionObject,
                                 Function<T, Object> searchPropertyAccessor, E searchText) {

        List<T> result = collectionObject.stream()
                .filter(item -> Objects.equals(searchPropertyAccessor.apply(item), searchText))
                .collect(Collectors.toList());
        return result;
    }
}
