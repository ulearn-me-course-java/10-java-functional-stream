package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
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

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        if( stream == null || order == null || minMaxConsumer == null)
            throw new NullPointerException();
        Iterator it = stream.iterator();
        if(it.hasNext())
        {
            T value = (T)it.next();
            T min = value;
            T max = value;
            while (it.hasNext())
            {
                value = (T)it.next();
                if(order.compare(value, min) < 0)
                    min = value;
                if (order.compare(value, max) > 0)
                    max = value;
            }
            minMaxConsumer.accept(min, max);
        }
        else
            minMaxConsumer.accept(null, null);
    }
}
