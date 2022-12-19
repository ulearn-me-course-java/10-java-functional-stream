package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        try (Stream<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines()) {
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        }



}
