package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main
{
    public static void main(String[] args)
    {
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .flatMap(x -> Stream.of(x.split("[^a-zA-Zа-яА-Я0-9ёЁ]+"))
                    .filter(w -> !w.isEmpty())
                    .map(String::toLowerCase))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(w -> System.out.print(w + "\n"));
    }
}
