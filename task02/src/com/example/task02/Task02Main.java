package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

    }

    static int graycode(int n) {
        return n^(n >> 1);
    }

    public static IntStream cycleGrayCode(int n) {
        if  ((n < 1) || (n > 16))
            throw new IllegalArgumentException();

        return IntStream.iterate(0, i -> i+1).map(i -> graycode(i%(int)Math.pow(2, n)));
    }
}
