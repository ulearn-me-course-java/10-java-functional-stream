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
                        System.out.println("min: " + min + " max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Iterator<? extends T> iterator = stream.iterator();
        T current = iterator.hasNext() ? iterator.next() : null;
        T min = current, max = current;
        while (iterator.hasNext()) {
            current = iterator.next();
            min = order.compare(current, min) < 0 ? current : min;
            max = order.compare(current, max) > 0 ? current : max;
        }
        minMaxConsumer.accept(min, max);
    }
}
