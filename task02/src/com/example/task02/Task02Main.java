package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {
        if(n <= 0 || n >= 17) throw new IllegalArgumentException(":c");
        return IntStream.iterate(0, e -> e + 1)
                .map(e -> e % (int)Math.pow(2, n))
                .map(Task02Main::GrayCode);
    }

    public static int GrayCode(int e){
        return e ^ (e >> 1);
    }

}
