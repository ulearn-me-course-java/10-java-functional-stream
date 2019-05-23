package com.example.task03;

import java.util.Comparator;
import java.util.List;
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

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> streamAsList = stream.sorted(order).collect(Collectors.toList());
        if (streamAsList.isEmpty()) minMaxConsumer.accept(null, null);
        else minMaxConsumer.accept(streamAsList.get(0), streamAsList.get(streamAsList.size() - 1));
    }
}
