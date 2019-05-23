package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()))) {
            reader.lines()
                    .flatMap(n -> Stream.of(n.split("\\P{L}+")))
                    .filter(n -> !n.isEmpty())
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(n -> n,
                            Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong((ToLongFunction<Entry<String, Long>>) Entry::getValue)
                            .reversed()
                            .thenComparing(Entry::getKey))
                    .limit(10)
                    .forEach(i -> System.out.print(i.getKey() + "\n"));
        }
    }
}