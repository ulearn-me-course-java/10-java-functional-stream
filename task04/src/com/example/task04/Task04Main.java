package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, UTF_8))) {
            bufferedReader
                    .lines()
                    .map(String::toLowerCase)
                    .flatMap(i -> Stream.of(i.split("[\\p{Punct}\\s]+")))
                    .filter(i -> !i.isEmpty())
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong((ToLongFunction<Map.Entry<String, Long>>) Map.Entry::getValue)
                            .reversed()
                            .thenComparing(Map.Entry::getKey))
                    .limit(10)
                    .forEach(i -> System.out.println(i.getKey()));
        }
    }

}
