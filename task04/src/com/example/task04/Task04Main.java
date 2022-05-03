package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {


        BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
        text.lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^а-яa-z0-9ё]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toMap(key -> key, value -> 1, Integer :: sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(x -> System.out.print(x + "\n"));
    }

}
