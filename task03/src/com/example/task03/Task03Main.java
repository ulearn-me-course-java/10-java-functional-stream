package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        if (stream == null || order == null || minMaxConsumer == null){
            throw new NullPointerException();
        }

        Iterator<? extends T> iterator = stream.iterator();
        if (!iterator.hasNext()){
            minMaxConsumer.accept(null, null);
            return;
        }

        T min = iterator.next();
        T max = min;

        while (iterator.hasNext()){
            T cur = iterator.next();
            if (order.compare(cur, min) < 0){
                min = cur;
            } else if (order.compare(max, cur) < 0) {
                max = cur;
            }
        }
        minMaxConsumer.accept(min, max);

    }
}
