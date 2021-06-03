package com.example.task03;

import java.util.Comparator;
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
        final Object[] values = new Object[]{null, null, true};
        stream.forEach(value -> {
            if ((boolean) values[2]) {
                values[0] = value;
                values[1] = value;
                values[2] = false;
            }
            if (order.compare(value, (T) values[0]) > 0) values[0] = value;
            if (order.compare(value, (T) values[1]) < 0) values[1] = value;
        });
        minMaxConsumer.accept((T) values[1], (T) values[0]);
    }
}
