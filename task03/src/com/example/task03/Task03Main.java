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

        Iterator<? extends T> iterator = stream.iterator();

        if(iterator.hasNext()) {
            T elMin = iterator.next();
            T elMax = elMin;
            while (iterator.hasNext()) {
                T el = iterator.next();

                if (order.compare(el, elMax) >= 0)
                    elMax = el;
                else if(order.compare(el, elMin) < 0 )
                    elMin = el;
            }

            minMaxConsumer.accept(elMin, elMax);

            return;
        }

        minMaxConsumer.accept(null, null);
    }
}
