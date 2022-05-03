package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    private static final Pattern PATTERN = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines()
                .map(String::toLowerCase)
                .flatMap(s -> Stream.of(PATTERN.split(s)))
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toMap(String::trim, o -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(s -> System.out.print(s + "\n"));
        reader.close();
    }

}
