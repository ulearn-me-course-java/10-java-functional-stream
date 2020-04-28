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

        if(stream == null || order == null || minMaxConsumer == null) throw  new NullPointerException();
        Iterator<? extends T> it = stream.iterator();
        if(!it.hasNext()){
            minMaxConsumer.accept(null, null);
            return;
        }
        T bufMin = it.next();
        T bufMax = bufMin;
        while(it.hasNext()){
            T temporary = it.next();
            if(order.compare(temporary, bufMax) > 0){
                bufMax = temporary;
            }
            if(order.compare(bufMin, temporary) > 0){
                bufMin = temporary;
            }
        }
        minMaxConsumer.accept(bufMin, bufMax);
    }
}
