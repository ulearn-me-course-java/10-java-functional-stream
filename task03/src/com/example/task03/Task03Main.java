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
        if(stream == null || order == null || minMaxConsumer == null){
            throw new NullPointerException();
        }
        Iterator<? extends T> iterator = stream.iterator();
        if(!iterator.hasNext()){
            minMaxConsumer.accept(null, null);
            return;
        }
        T value = iterator.next();
        T maxValue = value;
        T minValue = value;
        while(iterator.hasNext()){
            value = iterator.next();
            if (order.compare(value, minValue) < 0){
                minValue = value;
            }
            else if(order.compare(value, maxValue) > 0){
                maxValue = value;
            }
        }
        minMaxConsumer.accept(minValue, maxValue);
    }
}
