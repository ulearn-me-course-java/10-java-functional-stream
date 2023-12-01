package com.example.task04;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task04Main {
    public static void main(String[] args) throws IOException {

        System.setIn(new ByteArrayInputStream("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.".getBytes()));

        Stream<String> stringStream = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)).lines();
        stringStream.map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^a-zа-ёя0-9]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(t -> System.out.print(t.getKey()+"\n"));
    }

}
