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

        int[] m = new int[(int) Math.pow(2, n)];
        gray(n, m, 0);

        final int[] counter = {0};
        return IntStream.iterate(0, i -> {
            if (++counter[0] >= m.length)
                counter[0] = 0;

            return m[counter[0]];
        });
    }

    private static int gray(int n, int[] m, int depth) {
        int i, t = (1 << (depth - 1));

        if (depth == 0)
            m[0] = 0;
        else {
            for (i = 0; i < t; i++)
                m[t + i] = m[t - i - 1] + (1 << (depth - 1));
        }

        if (depth != n)
            gray(n, m, depth + 1);

        return m[depth + 1];
    }
}
