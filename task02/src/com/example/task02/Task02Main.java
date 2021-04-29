package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(3)
                .limit(10)
                .forEach(System.out::println);

        int sum = IntStream.iterate(0,n -> n+1)
                .limit(100)
                .sum();
        System.out.println(sum);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) { throw new IllegalArgumentException(); }
        return IntStream.iterate(0,x -> x + 1)
                .map(x -> (int)(x % Math.pow(2,n))) // Приведение к правильной форме осуществляется путём отбора по остатку.
                .map(x -> x ^ (x >> 1));           // Формула из вики - взаимозаменяет парные разряды;

    }

}
