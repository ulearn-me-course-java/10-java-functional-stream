package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
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
        if (stream == null || order == null || minMaxConsumer == null) {
            throw new NullPointerException();
        }

        Iterator<? extends T> iterator = stream.iterator();

        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T max = iterator.next();
        T min = max;

        while (iterator.hasNext()) {
            T elem = iterator.next();
            if (order.compare(elem, max) > 0) max = elem;
            if (order.compare(elem, min) < 0) min = elem;
        }
        minMaxConsumer.accept(min, max);
    }
}
