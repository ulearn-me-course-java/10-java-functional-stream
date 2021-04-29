package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(1),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        Iterator<? extends T> iterator = stream.iterator();
        T cur = iterator.hasNext() ? iterator.next() : null;
        T min = cur; T max = cur;
        while (iterator.hasNext()){
            cur = iterator.next();
            if(order.compare(cur,min) < 0)
                min = cur;
            else if(order.compare(cur,max) > 0)
                max = cur;
        }

        minMaxConsumer.accept(min,max);
    }
}
