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

    public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
      reader.lines()
            .map(String::toLowerCase)
            .flatMap(t -> Stream.of(t.split("\\P{L}+"))) //https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html "all none-letters many times"
            .filter(t -> !t.isEmpty())
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Comparator.comparingLong((ToLongFunction<Entry<String, Long>>) Entry::getValue)
                    .reversed()
                    .thenComparing(Entry::getKey))
            .limit(10)
            .forEach(t -> System.out.print(t.getKey() + "\n"));
    }
}
