package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in))
                .lines().
                flatMap(words -> Arrays.stream(words.split("[\\P{L}&&\\P{Digit}]")))
                .map(String::toLowerCase)
                .filter(x-> !x.equals(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue).reversed())
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + "\n"));
    }
}
