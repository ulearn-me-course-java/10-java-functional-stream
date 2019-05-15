package com.example.task02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16)
            throw new IllegalArgumentException();
        int[] initGray = IntStream.range(0, n).map(x -> 1 << x).toArray();
        int[] grayStyle = IntStream.rangeClosed(1, n).map(x -> 1 << x).toArray();
        AtomicInteger iteration = new AtomicInteger(1);
        int[] grayCodes = new int[1 << n];
        return IntStream.iterate(0, grayCode -> {
            if (iteration.get() >= grayCodes.length)
                return grayCodes[iteration.getAndIncrement() % grayCodes.length];
            int minInitGray = initGray[0];
            int minIndexGray = 0;
            for (int i = 1; i < n; i++) {
                if (minInitGray > initGray[i]) {
                    minInitGray = initGray[i];
                    minIndexGray = i;
                }
            }
            initGray[minIndexGray] += grayStyle[minIndexGray];
            return grayCodes[iteration.getAndIncrement()] = grayCode ^ 1 << minIndexGray;
        });
    }

}
