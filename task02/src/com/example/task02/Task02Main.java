package com.example.task02;

import java.util.function.Function;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16) throw new IllegalArgumentException();

        Function<Integer, Integer> grayenCode = g -> g ^ (g >> 1);
        int countInCircle = (int) Math.pow(2, n);

        return IntStream
                .iterate(0, i -> i + 1)
                .map(i -> grayenCode.apply(i % (countInCircle)));
    }
}

