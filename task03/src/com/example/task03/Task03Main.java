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

        Iterator iterator = stream.iterator();

        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T temporary = (T) iterator.next();
        T min = temporary;
        T max = temporary;

        while(iterator.hasNext()){
            temporary = (T) ((Iterator) iterator).next();
            if(order.compare(temporary,max) > 0)
                max = temporary;
            if(order.compare(temporary,min) < 0)
                min = temporary;
        }

        minMaxConsumer.accept(min, max);
    }
}
