package com.example.task04;

import java.io.*;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task04Main {

    public static void main(String[] args) {

//        String test = "Е Е А А Г Г В В Б Б";
//        System.setIn(new ByteArrayInputStream(test.getBytes()));

        Map<String, Long> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, UTF_8))) {
                reader
                    .lines()
                    .map(String::toLowerCase)
                    .filter(line -> !line.isEmpty())
                    .forEach(
                        line -> {
                            String new_line = line.replaceAll("\\p{Punct}", " ").
                                replaceAll("  ", " ").replaceAll(" ", ",");

                            for (String str: new_line.split(","))
                                map.put(str, map.containsKey(str) ? map.get(str) + 1 : 0);
                        }
                    );
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        map.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(10)
            .forEach(v -> System.out.print(v.getKey() + "\n"));
    }
}