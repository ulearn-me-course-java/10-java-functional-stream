package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n <= 0 || n >= 17) throw new IllegalArgumentException(":c");

        //int grayEncode = ;
        return IntStream.iterate(0, x ->  x + 1)
                .map(x -> x % (int) Math.pow(2, n))
                .map(x -> x ^ (x >> 1)); // your implementation here
    }

}
