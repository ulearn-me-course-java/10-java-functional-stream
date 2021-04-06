package com.example.task04;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Task04Main {
    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .flatMap(x -> Stream.of((x.split("[\\P{L}&&\\P{Digit}]"))))
                .filter(String::isEmpty)
                .map(String::toLowerCase)
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + "\n"));
    }
}
