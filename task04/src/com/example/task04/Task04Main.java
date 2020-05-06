package com.example.task04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.*;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task04Main {

        public static void main(String[] args) throws FileNotFoundException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
            reader.lines()
                    .map(String::toLowerCase)
                    .flatMap(t -> Stream.of(t.split("\\P{L}+")))
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