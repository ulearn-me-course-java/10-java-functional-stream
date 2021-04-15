package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(4)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) throw new IllegalArgumentException();
        return IntStream.iterate(0, c -> c + 1)
                .map(c -> c % (int) Math.pow(2, n))
                .map(c -> c ^ c >> 1);
    }

}
