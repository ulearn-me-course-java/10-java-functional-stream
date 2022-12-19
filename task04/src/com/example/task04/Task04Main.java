package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {
        Stream<String> stream = new BufferedReader(new InputStreamReader(System.in)).lines();

        stream.map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^a-zа-яё0-9]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong((ToLongFunction<Map.Entry<String, Long>>)Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + '\n'));
    }
}
