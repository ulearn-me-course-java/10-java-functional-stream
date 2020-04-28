package com.example.task04;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task04Main {

    /*
    * hi hi hi123 123 -> ["hi", "hi","hi123", "123"]
    * helo helo
    *
    * */

    // flatMap in: Stream<Stream<String>> -> Stream

    // [\\P{L}&&[^0-9]]+
    // \\P{L} -- всё кроме букв (символы + цифры)
    // && -- пересечение
    // [\\D] -- всё кроме цифр
    // + - один или более раз
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        List<String> collect1 = reader.lines()
                .map(String::toLowerCase)
                .map(s -> Arrays.stream(s.split("[\\P{L}&&[\\D]]+"))).flatMap(i -> i)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

       // collect1.forEach(System.out::println);

        Map<String, Long> collect = collect1.stream()
                .collect(groupingBy(Function.identity(), counting()));

   //     collect.forEach((s1, s2)-> System.out.println(s1 + ": " + s2));

        ToLongFunction<Map.Entry<String, Long>> toLongFunction = s -> s.getValue();

        Comparator<Entry<String, Long>> comparator = Comparator.comparingLong(toLongFunction)
                .reversed()
                .thenComparing(s->s.getKey());


                collect
                .entrySet()
                .stream()
                .sorted(comparator)
                .limit(10)
                .forEach(s -> System.out.print(s.getKey() + "\n"));
    }

}
