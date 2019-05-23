package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        Hashtable<String, Integer> dictionary = new Hashtable<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))) {
            reader.lines()
                    .map(x -> x.replace(',', ' ').replace('.', ' ').replace('-', ' ').replace('!', ' '))
                    .flatMap(x -> Arrays.stream(x.split(" ")))
                    .filter(x -> !x.equals(".") && !x.equals(",") && !x.equals(""))
                    .map(String::toLowerCase)
                    .forEach(x ->
                    {
                        if(!dictionary.containsKey(x))
                            dictionary.put(x, 0);

                        dictionary.replace(x, dictionary.get(x) + 1);
                    });
        }

        dictionary.keySet().stream()
                .sorted()
                .sorted(Comparator.comparing(x -> dictionary.keySet().size() - dictionary.get(x)))
                .limit(10)
                .forEach(System.out::println);
    }
}
