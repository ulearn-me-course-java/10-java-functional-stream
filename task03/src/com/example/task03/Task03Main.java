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

        if (stream == null || order == null || minMaxConsumer == null) {
            throw new NullPointerException();
        }

        Iterator<? extends T> iterator = stream.iterator();
        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T maxValue = iterator.next();
        T minValue = maxValue;
        while (iterator.hasNext()) {
            T elem = iterator.next();
            if (order.compare(elem, maxValue) >= 0) {
                maxValue = elem;
            } else if (order.compare(minValue, elem) >= 0) {
                minValue = elem;
            }
        }
        minMaxConsumer.accept(minValue, maxValue);

    /*List<T> list = stream.collect(Collectors.toList());
    if(list.isEmpty()){
        minMaxConsumer.accept(null, null);
        return;
    }
    Optional<? extends T> maxNumber = list.stream().max(order);
    Optional<? extends T> minNumber = list.stream().min(order);
    minMaxConsumer.accept(minNumber.get(), maxNumber.get());*/
    }
}

