package com.example.task03;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );
        Tests tests = new Tests();

        tests.testEmpty();
        tests.testExample();
        tests.testNull();
        tests.testBig();
        tests.testNPE();
        tests.testString();
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        if (stream == null || order == null || minMaxConsumer == null){
            throw new NullPointerException();
        }

        Iterator<? extends T> iterator = stream.iterator();

        T min = null;
        T max = null;
        if (iterator.hasNext()){
            min = iterator.next();
            max = min;
        }

        while (iterator.hasNext()){
            T currentElement = iterator.next();
            if (order.compare(currentElement,max)>0){
                max = currentElement;
            }
            if (order.compare(currentElement,min)<0){
                min = currentElement;
            }
        }
        minMaxConsumer.accept(min,max);
    }
}
