package com.example.task03;

import java.lang.reflect.Array;
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
        T[] streamCopy = (T[]) stream.toArray();
        if (order == null || stream == null) throw new NullPointerException();
        if (streamCopy.length == 0)
            minMaxConsumer.accept(null, null);
        else {
            Arrays.sort(streamCopy, order);
            minMaxConsumer.accept(streamCopy[0], streamCopy[streamCopy.length - 1]);
        }
        // your implementation here
    }
}
