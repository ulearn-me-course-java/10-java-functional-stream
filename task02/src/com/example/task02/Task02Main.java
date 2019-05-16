package com.example.task02;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);

        if (n > 16 || n == 0){
            throw new IllegalArgumentException();
        }
        for (int i = 1; i < n; i++) {
            List<Integer> reverse = new LinkedList<>(list);
            Collections.reverse(reverse);

            for (int j = 0; j < reverse.size(); j++) {
                reverse.set(j, reverse.get(j) + (1 << i));
            }
            list.addAll(reverse);
        }
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        return Stream.iterate(0, i -> i + 1).mapToInt(i -> list.get(i % list.size()));
    }
}
