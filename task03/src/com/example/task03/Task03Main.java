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

        T min = null, max = null;
        Iterator<? extends T> iterator = stream.iterator();
        if(iterator.hasNext()){
            min = iterator.next();
            max = min;
        }

        while(iterator.hasNext()){
            T e = iterator.next();
            if(order.compare(e, max) > 0)
                max = e;
            if(order.compare(e, min) < 0)
                min = e;
        }

        minMaxConsumer.accept(min, max);
    }
}
