package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {

        if(n > 16 || n < 1) throw new IllegalArgumentException("значения от 1 до 16");

        int grayCodeLength = (int) Math.pow(2, n);

        return IntStream.iterate(0, i -> i + 1)
                .map(i -> grayCode(i % grayCodeLength));
    }

    static int grayCode(int g){
        return g ^ (g >> 1);
    }

}
