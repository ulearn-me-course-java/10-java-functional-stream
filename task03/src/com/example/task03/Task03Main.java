package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
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
        T min = null, max = null;
        if (iterator.hasNext()) {
            T firstElement = iterator.next();
            min = firstElement;
            max = firstElement;
        }

        while (iterator.hasNext()) {
            T element = iterator.next();
            if (order.compare(element, min) < 0)
                min = element;
            if (order.compare(element, max) > 0)
                max = element;
        }

        minMaxConsumer.accept(min, max);
    }
}
