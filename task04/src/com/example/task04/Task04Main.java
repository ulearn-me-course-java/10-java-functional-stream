package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().map(String::toLowerCase).flatMap(x -> Stream.of(x.split("[^\\da-zа-яё]")))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(10)
                .forEach(x -> System.out.printf("%s ", x));
    }

}
