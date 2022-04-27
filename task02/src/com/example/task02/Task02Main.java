package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {

        if (IntStream.rangeClosed(1, 16).filter(x -> x == n).count() == 0)
            throw new IllegalArgumentException();
        else
            return IntStream.iterate(0, operand -> operand + 1)
            .map(a -> a % (int) Math.pow(2, n))
            .map(a -> a ^ (a >> 1));

    }

}
