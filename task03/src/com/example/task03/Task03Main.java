package com.example.task03;

import java.util.*;
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

       Iterator i = stream.iterator();

       T min;
       T max;
       if(!i.hasNext()) {
           minMaxConsumer.accept(null, null);
           return;
       }
       min = ((T) i.next());
       max = min;
       while(i.hasNext()){
           T el = (T) i.next();
           if(order.compare(el, min) < 0 ) min = el;
           if(order.compare(el, max) > 0) max= el;

       }
        minMaxConsumer.accept(min, max);
    }
}
