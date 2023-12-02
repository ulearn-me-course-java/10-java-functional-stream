package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16)
            throw new IllegalArgumentException();
        return IntStream.iterate(0, a -> a >= Math.pow(2, n) - 1 ? 0 : a + 1)
                .map(b -> b ^ (b >> 1));
    }

}
