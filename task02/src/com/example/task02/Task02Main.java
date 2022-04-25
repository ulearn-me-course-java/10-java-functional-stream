package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
    }
    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) // проверка на число от 1 до 15
            throw new IllegalArgumentException("Incorrect argument!");
        int grayCodelength = (int) Math.pow(2, n);
        return IntStream
                .iterate(0, i -> i + 1) // итерируемся по каждому числу потока
                .map(i -> getGrayCode(i % grayCodelength)); // приводим к нужной длине
    }
    private static int getGrayCode(int i) { // преобразование в код грея (формула с вики)
        return  i ^ (i >> 1);
    }

}
