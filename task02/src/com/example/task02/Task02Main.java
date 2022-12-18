package com.example.task02;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {
        if(n <= 0 || n > 16) throw new IllegalArgumentException();

        double maxValue = Math.pow(2, n);
        int[] value = new int[] {0}, count = new int[] {0};
        //IntSupplier
        return IntStream.generate(() ->
        {
            if(count[0] == maxValue) { value[0] = 0; count[0] = 0; }
            int res = value[0] ^ (value[0] >> 1);
            value[0]++; count[0]++;
            return res;
        });
    }

}
