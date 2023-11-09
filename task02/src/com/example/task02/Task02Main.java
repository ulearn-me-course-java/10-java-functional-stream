package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) throw new IllegalArgumentException();
        double maxValue = Math.pow(2, n);
        final int[] count = {0};
        final int[] value = {0};
        return IntStream.generate(() -> {
            if (count[0] == maxValue) {
                value[0] = 0;
                count[0] = 0;
            }
            int result = value[0] ^ (value[0] >> 1);
            value[0]++;
            count[0]++;
            return result;
        });
    }

}
