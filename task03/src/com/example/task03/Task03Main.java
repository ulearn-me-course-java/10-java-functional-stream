package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
        if (stream == null || order == null || minMaxConsumer == null)
            throw new NullPointerException();

        // your implementation here
        Iterator <? extends T> iterator = stream.iterator();
        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null,null);
            return;
        }
        T min = iterator.next();
        T max = min;

        while (iterator.hasNext()){
            T num = iterator.next();
            if (order.compare(min,num) > 0)
                min = num;
            if (order.compare(max,num) < 0)
                max = num;
        }

        minMaxConsumer.accept(min,max);
    }
}
