package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        if (n <= 0 || n > 16)
            throw new IllegalArgumentException();

        StringBuilder str= new StringBuilder();
        for(int i = 0; i< n ;i++) str.append('1');
        return IntStream.iterate(0, x-> (x+1)%(Integer.parseInt(str.toString(),2)+1) )
               .map(x-> x^x>>>1);


    }

}
