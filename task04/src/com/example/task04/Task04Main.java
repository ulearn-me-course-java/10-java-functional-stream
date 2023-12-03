package com.example.task04;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    private static boolean isTest = false;

    public static void main(String[] args) {
        if (isTest) {
            analyzeFrequency();
        } else {
            System.setIn(new ByteArrayInputStream("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.".getBytes()));
            analyzeFrequency();
            test();
        }
    }

    private static void analyzeFrequency() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        reader.lines()
                .map(String::toLowerCase)
                .flatMap(line -> Stream.of(line.split("[^a-zа-яё0-9]"))) // разделяет строку на слова с помощью всех символов, не входящих в набор
                .filter(word -> !word.isEmpty()) // Убирает пустые слова
                .collect(Collectors.groupingBy(n -> n, Collectors.counting())) // Сгрупировать по словам в словарь, где ключ - слово, а значение - колличество
                .entrySet() // делаем из словаря набор Map.Entry из ключей из значений
                .stream() // достаём поток
                .sorted(Map.Entry.comparingByKey()) // сортировка по ключам
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // сортировка по значениям
                .limit(10) // ограничить до 10 штук
                .forEach(t -> System.out.print(t.getKey() + "\n")); // вывод
    }

    private static void test() {
        isTest = true;
        Tests tests = new Tests();
        try {
            tests.testExample1();
            tests.testExample2();
            tests.testMarshak();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
