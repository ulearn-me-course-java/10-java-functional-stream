package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {
        if (n>16 || n<1){
            throw new IllegalArgumentException("Argument is out of range");
        }

        return IntStream
                .iterate(0, x->x+1)
                .map(x->grayencode(x % (int)Math.pow(2,n)));

    }
    static int grayencode(int g)
    {
        return g ^ (g >> 1); //g XOR g(на 1 вправо)
    }

}
