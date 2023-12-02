package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(7)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16)
            throw new IllegalArgumentException();

        int length = (int) Math.pow(2, n);
        return IntStream
                .iterate(0, i -> i + 1)
                .map(i -> grayCode(i % length));
    }
    public static int grayCode(int g) {
        return  g ^ (g >> 1);
    }

}
