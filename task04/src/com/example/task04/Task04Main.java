package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            br.lines()
                    .map(String::toLowerCase)
                    .flatMap(str -> Stream.of(str.split("[^\\wа-яё]")))
                    .filter(str -> !str.trim().isEmpty())
                    .collect(Collectors.toMap(str -> str, value -> 1, Integer :: sum))
                    . entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(str -> System.out.print(str.getKey() + "\n"));
        }
    }

}
