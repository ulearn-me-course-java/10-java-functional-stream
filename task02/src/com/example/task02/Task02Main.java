package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main
{

    public static void main(String[] args)
    {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n)
    {

        if (n > 0 && n < 17)
        {
            int length = (int) Math.pow(2, n);
            return IntStream
                    .iterate(0, i -> i + 1)
                    .map(x -> (x % length) ^ ((x % length) >> 1));

        }
        throw new IllegalArgumentException();
    }

}
