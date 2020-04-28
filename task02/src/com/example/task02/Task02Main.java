package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        int n = 2;
        IntStream.iterate(0, i -> i + 1).map(i -> encode2Gray(i, n)).limit(10).forEach(System.out::println);

        /*
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
        */

    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16) {
            throw new IllegalArgumentException("Wrong bit number.");
        }

        return IntStream.iterate(0, i -> i + 1).map(i -> encode2Gray(i, n));

    }

    static int encode2Gray(int value, int n) {
        int s = 1;
        s = (s << n) - 1;
        value = value & s;

        return value ^ value >> 1;
    }
}
