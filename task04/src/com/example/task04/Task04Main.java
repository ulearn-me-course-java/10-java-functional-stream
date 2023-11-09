package com.example.task04;

import org.assertj.core.data.MapEntry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^ёа-яa-z0-9]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(y -> y, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

}
