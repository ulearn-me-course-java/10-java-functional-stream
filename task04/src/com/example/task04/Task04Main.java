package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> string = new ArrayList<>();
        Map<String,Long> dictionary = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String x;

        //while(!(x = br.readLine()).equals("")) { string.add(x); }

        /*string.stream()
                .map(String::toLowerCase)
                .map(String::toCharArray)
                .filter(stroke -> {
                    for (char sym : stroke) {
                        if (
                                (sym >= 'a' && sym <= 'z') || (sym >= '0' && sym <= '9')
                        ) { return true; }
                    }
                    return false;
                })
                .map(Objects::toString)
                .forEach(stroke -> dictionary.put(stroke,string.stream().filter(stroke::equals).count()));
        */
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        buffReader.lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[\\P{L}&&\\P{Digit}]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toMap(key->key, value->1, Integer::sum)) // Создаётся map collection. Первые два аргумента определяют ключ и значение равно 1 - если значения совпадают, то с помощью marge функции значение по ключу будет равно сумме элементов.
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(x -> System.out.print(x+'\n'));
    }
}
