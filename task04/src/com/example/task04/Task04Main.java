package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        try (Stream<String> lines = new BufferedReader(new InputStreamReader(inputStream)).lines()) {
            lines.map(String::toLowerCase)
                    .flatMap(e -> Stream.of(e.split("[\\P{L}&&\\P{Digit}]")))
                    .filter(e -> !e.isEmpty())
                    .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .forEach(e -> System.out.print(e + '\n'));
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
