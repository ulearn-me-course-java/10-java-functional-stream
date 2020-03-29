package com.example.task02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(3)
                .limit(100)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n > 16 || n < 1)
            throw new IllegalArgumentException();

        int codeLength = (int) Math.pow(2, n);

        return IntStream
                .iterate(0, it -> (it + 1) % codeLength)
                .map(Task02Main::nextGrayNumber);
    }

    private static int nextGrayNumber(int current){
        return current ^ (current >> 1);
    }
}
