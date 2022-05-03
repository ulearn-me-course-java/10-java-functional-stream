package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2) // наш метод //программа понимает что это поток потому что мы сами возращаем поток
                .limit(10) // ограничеваем элементы
                .forEach(System.out::println); // показываем что хотим поэлементно вывести отправляя IntConsumer в виде System.out::println
    }

    public static IntStream cycleGrayCode(int n) {
     if (n > 16 || n < 1) {
        throw new IllegalArgumentException();
    }
    int count = (int) Math.pow(2, n);
        return IntStream.iterate(0, x -> x + 1) // возрат потока // переберает элементы
            .map(x -> getGray(x % count)); // преобразуем x делением на count и получаем из getGray число вместо x

    }

    public static int getGray(int g) {
        return g ^ (g >> 1); // оператор побитовое исключающее ИЛИ // Побитовый сдвиг вправо
    }

}
