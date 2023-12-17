package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String input = reader.readLine().toLowerCase();

        String[] words = input.split("[^\\p{L}\\p{N}]+");

        Map<String, Long> wordFrequency = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        Map<String, Long> sortedByFrequencyAndAlphabet = wordFrequency
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedByFrequencyAndAlphabet.entrySet().stream()
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    }

}
