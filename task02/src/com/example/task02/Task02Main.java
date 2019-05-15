package com.example.task02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(3)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> reverse = new ArrayList<>(list);
            Collections.reverse(reverse);

            for (int j = 0; j < reverse.size(); j++) {
                reverse.set(j, reverse.get(j) + (int)Math.pow(2,i));
            }
            list.addAll(reverse);
        }
        return list.stream().mapToInt(x -> x);
    }
}
