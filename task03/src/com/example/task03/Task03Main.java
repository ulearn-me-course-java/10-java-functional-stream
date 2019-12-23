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

        Iterator it = stream.iterator();
        if (!it.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T e = (T) it.next(), min = e, max = e;
        while (it.hasNext()) {
            e = (T) it.next();
            if (order.compare(e, min) < 0)
                min = e;
            if (order.compare(e, max) > 0)
                max = e;
        }
        minMaxConsumer.accept(min, max);
    }
}
