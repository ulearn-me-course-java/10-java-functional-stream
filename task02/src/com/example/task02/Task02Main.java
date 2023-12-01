package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

        Tests tests = new Tests();
        tests.test10();
        tests.test12();
        tests.test16();
        tests.testBounds();
        tests.testExample1();
        tests.testExample2();
    }

    public static IntStream cycleGrayCode(int n) {

        if (n>=1 && n<=16){
            return IntStream.iterate(0,k->k+1)
                    .map(x -> x % (int)Math.pow(2,n))
                    .map(el->el ^ (el >> 1));
        }
        throw new IllegalArgumentException();
    }

}
