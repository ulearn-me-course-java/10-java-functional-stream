package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println(Integer.rotateLeft(1, 2));
        System.out.println(1 << 2);
    }

    public static IntStream cycleGrayCode(int n) {
        if(n < 1 || n > 16) throw new IllegalArgumentException();
        int ceiling = 1 << n;
        return IntStream.iterate(0, i -> i = i + 1).map(i -> {
            i = i % ceiling;
            i = i ^ (i >> 1);
            return i;
        });
    }

}
