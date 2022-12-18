package com.example.task02;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {

        /*
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
        */

    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16)
            throw new IllegalArgumentException();
        return IntStream.iterate(0, i -> i + 1).map(i -> getGrayCode(i % (int) Math.pow(2, n)));
    }

    private static int getGrayCode(int i) {
        return  i ^ (i >> 1);
    }

}
