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


        Iterator<? extends T> iterator = stream.iterator();
        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T next = iterator.next();
        T min = next;
        T max = next;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (order.compare(min, next) > 0)
                min = next;
            if (order.compare(max, next) < 0)
                max = next;
        }
        minMaxConsumer.accept(min, max);
    }
}
