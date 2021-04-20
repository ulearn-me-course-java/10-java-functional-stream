package com.example.task04;

import org.assertj.core.groups.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(
                new InputStreamReader( System.in));
        in.lines()
                .flatMap(x-> Stream.of(x.split("[:.;!, -]")))
                .map(String ::toLowerCase)
                .filter(x-> !x.isEmpty())
                .collect(Collectors.groupingBy(x ->x ,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(t -> System.out.print(t + '\n'));


        in.close();

    }

}
