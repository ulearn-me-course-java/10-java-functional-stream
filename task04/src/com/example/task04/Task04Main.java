package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Task04Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(reader.lines()
                        .map(x -> x + " ")
                        .flatMap(x -> x.chars().mapToObj(y -> (char) y))
                        .map(x -> Character.isLetterOrDigit(x) ? x : ' ')
                        .map(Character::toLowerCase)
                        .map(String::valueOf).collect(Collectors.joining())
                        .split(" ")
                ).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(11)
                .forEach(x -> System.out.print(x.getKey() + "\n"));
    }
}
