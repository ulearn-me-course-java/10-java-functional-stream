package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {
        if (n <= 0 || n > 16){
            throw new IllegalArgumentException();
        }

        final int mask = (1 << n) - 1;
        return IntStream
                .iterate(0, x -> (x + 1) & mask)
                .map(x -> x ^ (x >> 1));
    }
}
