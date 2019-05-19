package com.example.task02;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n > 16 || n == 0){
            throw new IllegalArgumentException();
        }
        ArrayList<AtomicInteger> arr = new ArrayList<>();
        gray(n, arr, 0);
        return Stream.iterate(0, c -> c >= arr.size() - 1 ? 0 : c + 1).mapToInt(c -> arr.get(c).get());
    }

    static void gray (int n,  ArrayList<AtomicInteger> m, int depth)
    {
        int i, t = (1 << (depth - 1));

        if (depth == 0) {
            m.add(new AtomicInteger(0));
        }

        else {
            for (i = 0; i < t; i++)
                m.add(new AtomicInteger(m.get(t - i - 1).get() + (1 << (depth - 1))));
        }
        if (depth != n)
            gray(n, m, depth + 1);
    }
}

