package com.vladproduction.appliances.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CsvStorageImpl implements CsvStorage{

    public static final String DELIMITER = ",";

    @Override
    public <T> List<T> read(InputStream source, Function<String[], T> mapper) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(source);
        byte[] readAllBytes = bin.readAllBytes();
        String content = new String(readAllBytes);
        String[] lines = content.split("\n");
        List<T> result = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(DELIMITER);
            T t = mapper.apply(values);
            result.add(t);
        }
        return result;
    }

    @Override
    public <T> void write(OutputStream dest, List<T> values, Function<T, String[]> mapper) throws IOException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.size(); i++ ){
            String[] strings = mapper.apply(values.get(i));
            String line = stringSeparator(strings);
            result.append(line);
            if(i != values.size() - 1){
                result.append("\n");
            }
        }
        byte[] bytes = result.toString().getBytes();
        dest.write(bytes);
    }

    private String stringSeparator(String[] strings){
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
            result.append(DELIMITER);
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
