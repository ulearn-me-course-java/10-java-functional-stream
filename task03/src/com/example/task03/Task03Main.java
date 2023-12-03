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

        if(iterator.hasNext()){
            T minElement = iterator.next();
            T maxElement = minElement;

            while (iterator.hasNext()){
                T currentElement = iterator.next();
                if (order.compare(currentElement, maxElement) >= 0){
                    maxElement = currentElement;
                }
                if (order.compare(currentElement,minElement)<0){
                    minElement = currentElement;
                }

                minMaxConsumer.accept(minElement, maxElement);
                return;
            }
        }

        minMaxConsumer.accept(null, null);


        // your implementation here
    }
}
