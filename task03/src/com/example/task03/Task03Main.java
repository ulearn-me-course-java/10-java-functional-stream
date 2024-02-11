package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.Iterator;
import java.util.stream.Stream;

public class Task03Main {
    public static <T> void findMinMax(
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        Iterator<? extends T> iter = stream.iterator();

        if(iter.hasNext())
        {
            T min = iter.next();
            T max = min;

            while (iter.hasNext())
            {
                T element = iter.next();

                if (order.compare(element, max) >= 0)
                    max = element;
                else if(order.compare(element, min) < 0 )
                    min = element;
            }
            minMaxConsumer.accept(min, max);
            return;
        }

        minMaxConsumer.accept(null, null);
    }
}