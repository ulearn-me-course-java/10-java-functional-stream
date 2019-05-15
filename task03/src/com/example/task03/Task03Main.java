package com.example.task03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
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
        if (stream == null || order == null)
            throw new NullPointerException();
        T[] arrStream = (T[]) stream.toArray();
        if (arrStream.length != 0) {
            T min = getValueOrNull(() -> Arrays.stream(arrStream).min(order).get());
            T max = getValueOrNull(() -> Arrays.stream(arrStream).max(order).get());
            minMaxConsumer.accept(min, max);
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    static <T> T getValueOrNull(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
