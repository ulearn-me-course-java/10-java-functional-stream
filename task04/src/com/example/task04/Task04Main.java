package com.example.task04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task04Main {

    public static void main(String[] args) throws IOException {
        AtomicReference<StringBuilder> stringBuilder = new AtomicReference<>(new StringBuilder());
        Map<String, Integer> stringMap = new HashMap<>();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in, Charset.defaultCharset());

        Stream.iterate(inputStreamReader.read(),
                n -> {
                    char chr = (char) n.intValue();
                    if (Character.isLetter(chr))
                        stringBuilder.get().append(Character.toLowerCase(chr));
                    else if (stringBuilder.get().length() != 0) {
                        String word = stringBuilder.toString();
                        stringMap.put(word, stringMap.containsKey(word) ? stringMap.get(word) + 1 : 1);
                        stringBuilder.set(new StringBuilder());
                    }
                    try {
                        return inputStreamReader.read();
                    } catch (IOException e) {
                        return -1;
                    }
                }).anyMatch(x -> x == -1);

        stringMap.entrySet().stream()
                .sorted((a, b) -> {
                    Integer v1 = a.getValue();
                    Integer v2 = b.getValue();
                    return !v1.equals(v2) ? v2.compareTo(v1) : a.getKey().compareTo(b.getKey());
                })
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + '\n'));
    }
}