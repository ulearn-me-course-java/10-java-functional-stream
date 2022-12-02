package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        try (Stream<String> s = new BufferedReader(new InputStreamReader(System.in, Charset.forName("utf-8"))).lines()) {

            s.map(String::toLowerCase)
                    .flatMap(x -> Stream.of(x.split("[\\P{L}&&\\P{Digit}]")))
                    .filter(x -> !x.isEmpty())
                    .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .forEach(System.out::println);
        }
    }

}
