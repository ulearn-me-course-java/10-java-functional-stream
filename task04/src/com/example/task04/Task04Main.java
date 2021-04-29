package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task04Main {

    public static void main(String[] args) {

        // your implementation here
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        buffReader.lines()
                .flatMap(x -> Stream.of(x.toLowerCase().split("[^\\da-zA-Zа-яёА-ЯЁ]")))
                .filter(x -> !x.isEmpty())
                .collect(groupingBy(x -> x, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + '\n'));
    }

}
