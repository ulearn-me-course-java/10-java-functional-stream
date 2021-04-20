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
        if (n < 1 || n > 16)
            throw new IllegalArgumentException();
        int[] boxedCounter = {0};
        return IntStream.generate(() -> getNext(boxedCounter[0]++, n));
    }

    private static int getNext(int index, int bitsCount) {
        int[] result = {0};
        IntStream.range(1, bitsCount).forEach(i -> {
            int period = (int) Math.pow(2, i + 1);
            if (index % period >= period / 4 && index % period < 3 * period / 4)
                result[0] += Math.pow(2, i - 1);
        });
        int period = (int) Math.pow(2, bitsCount);
        if (index % period >= period / 2)
            result[0] += Math.pow(2, bitsCount - 1);
        return result[0];
    }
}
