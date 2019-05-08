package com.example.task02;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {



    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16)
            throw new IllegalArgumentException();
        int countInCycle = (int) Math.pow(2, n);
        return IntStream.iterate(0, i -> i + 1)
                .map(i -> g(i % countInCycle));
    }

    private static int g (int n) {
        return n ^ (n >> 1);
    }

}
