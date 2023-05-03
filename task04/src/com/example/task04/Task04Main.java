package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.lines()
                .map(String :: toLowerCase)
                .flatMap(x -> Stream.of(x.split("[\\P{L}&&\\P{Digit}]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toMap(key -> key, value -> 1, Integer :: sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry :: getKey)
                .forEach(x -> System.out.print(x + "\n"));
    }


}
