package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        if (n > 16 || n < 1)
            throw new IllegalArgumentException();

        return IntStream
                .iterate(0, it -> (it + 1) % (int) Math.pow(2, n))
                .map(Task02Main::nextNumber);
    }

    private static int nextNumber(int current) {
        return current ^ (current >> 1);
    }
}
