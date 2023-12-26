package com.example.task02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
/*
        System.out.println("Grey code for " + 7 + " at n-bit: " + getGreyCode(7));
        System.out.println("Grey code for " + 7 + " at 5-bit: " + getGreyCode(7, 5));
        int foo = Integer.parseInt("10", 3);
        System.out.println(foo);
        */

    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16)
            throw new IllegalArgumentException();
        IntStream steam = IntStream.iterate(0, i -> i + 1)
                .map( i -> (int) (i % Math.pow(2, n)))
                .map( i -> Integer.parseInt(getGreyCode(i), 2));


        return steam; // your implementation here

    }
    static String getGreyCode(int myNum, int numOfBits) {
        if (numOfBits == 1) {
            return String.valueOf(myNum);
        }

        if (myNum >= Math.pow(2, (numOfBits - 1))) {
            return "1" + getGreyCode((int)(Math.pow(2, (numOfBits))) - myNum - 1, numOfBits - 1);
        } else {
            return "0" + getGreyCode(myNum, numOfBits - 1);
        }
    }

    static String getGreyCode(int myNum) {
        if (myNum == 0) {
            return "0";
        }
        //Use the minimal bits required to show this number
        int numOfBits = (int)(Math.log(myNum) / Math.log(2)) + 1;
        return getGreyCode(myNum, numOfBits);
    }

}
