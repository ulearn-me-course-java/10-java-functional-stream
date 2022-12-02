package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
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

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Iterator<? extends T> it = stream.iterator();
        T min = it.hasNext() ? it.next() : null;
        T max = min;

        while (it.hasNext()) {
            T current = it.next();
            if (order.compare(current, min) < 0) min = current;
            else if (order.compare(current, max) > 0) max = current;
        }

        minMaxConsumer.accept(min, max);
    }
}
