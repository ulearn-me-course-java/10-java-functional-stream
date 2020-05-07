package com.example.task04;

import java.io.BufferedReader;
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
                .flatMap(it -> Stream.of(it.split("\\P{LD}+"))) //letter or digit,  one or more times
                .filter(it -> !it.isEmpty())
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong((ToLongFunction<Entry<String, Long>>) Entry::getValue)
                        //принимает функцию в качестве параметра, которая извлекает длинный ключ сортировки из типа T,
                        //и возвращает Comparator, который сравнивается по этому ключу сортировки
                        .reversed() //сортирует массив в обратном порядке
                        .thenComparing(Entry::getKey)) //что он делает
                .limit(10)
                .forEach(t -> System.out.print(t.getKey() + "\n"));
    }

}
