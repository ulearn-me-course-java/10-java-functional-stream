package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(3)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16)
            throw new IllegalArgumentException();

        int max = 1 << n;
        return IntStream.iterate(0, operand -> (operand + 1) % max).map(i -> i ^ (i >> 1));
    }
}
