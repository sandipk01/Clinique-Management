package com.bridgelabz.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    private static ObjectMapper mapper;

    private FileSystem() {

    }

    static {
        mapper = new ObjectMapper();
    }

    public static <T> void saveFile(File file, List<T> list) throws IOException {
        mapper.writeValue(file, list);
    }

    public static <T> List<T> readFile(File file) throws IOException {
        return mapper.readValue(file, new TypeReference<ArrayList<T>>() {
        });
    }
}
