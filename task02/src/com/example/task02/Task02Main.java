package com.example.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        /*
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
        */
        cycleGrayCode(0);
        for (int a : cycleGrayCode(0).toArray()) {
            System.out.println(a);
        }
    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) throw new IllegalArgumentException();
        int coef = (int) Math.pow(2, n);
        return IntStream.iterate(0, x -> (x + 1) % coef)
                .map(x -> x ^ (x >> 1)); // your implementation here

    }

}
