package com.example.task02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(3)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n > 16 || n < 1)
            throw new IllegalArgumentException();

        int[] arr = new int[(int) Math.pow(2, n)];
        gray(n, arr, 0);

        return IntStream.of(arr);
    }

    static void gray(int n, int[] m, int depth) {
        int t = (1 << (depth - 1));

        if (depth == 0) {
            m[0] = 0;
        } else {
            for (int i = 0; i < t; i++)
                m[t + i] = m[t - i - 1] + (1 << (depth - 1));
        }
        if (depth != n)
            gray(n, m, depth + 1);
    }

}
