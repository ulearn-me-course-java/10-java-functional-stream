package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()))) {
            reader.lines()
                    .map(String::toLowerCase)
                    .flatMap(e -> Stream.of(e.split("\\P{L}+")))
                    .filter(e -> !e.isEmpty())
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong((ToLongFunction<Map.Entry<String, Long>>) Map.Entry::getValue)
                            .reversed()
                            .thenComparing(Entry::getKey))
                    .limit(10)
                    .forEach(e -> System.out.print(e.getKey() + "\n"));
        }

    }

}
