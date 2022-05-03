package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main
{

    public static void main(String[] args)
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            reader.lines()
                    .flatMap(x -> Stream.of(x.toLowerCase().split("[^\\da-zA-Zа-яёА-ЯЁ]")))
                    .filter(x -> !x.isEmpty())
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(x -> System.out.print(x.getKey() + '\n'));
            ;
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
