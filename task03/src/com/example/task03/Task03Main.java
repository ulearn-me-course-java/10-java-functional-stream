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
            T[] arr = (T[]) stream.sorted(order).toArray();
            if(arr.length == 0)
            {
                minMaxConsumer.accept(null, null);
                return;
            }
            T min = arr[0];
            T max = arr[arr.length-1];
            minMaxConsumer.accept(min, max);
        // your implementation here
    }
}
