package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

        Tests tests = new Tests();
        tests.testExample1();
        tests.testExample2();
        tests.test10();
        tests.test12();
        tests.test16();
        tests.testBounds();
    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16) {
            throw new IllegalArgumentException();
        }

        return IntStream.iterate(0, x -> x + 1)
                .map(x -> x % (int) Math.pow(2, n)) // .map(x -> (x & ((2 << (n - 1)) - 1)))
                .map(x -> x ^ (x >> 1));
    }
}
