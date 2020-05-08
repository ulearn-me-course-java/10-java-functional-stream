package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import java.util.Iterator;

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
        //Необработанное использование параметризованного класса 'Iterator'

        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T t = (T) iterator.next(), min = t, max = t;
        //Не проверено приведение: «java.lang.Object» к «T».
        // Причина: «итератор» имеет необработанный тип, поэтому результат следующего удаляется

        while (iterator.hasNext()) {
            t = (T) iterator.next();
            if (order.compare(t, max) > 0)
                max = t;
            if (order.compare(t, min) < 0)
                min = t;
        }
        minMaxConsumer.accept(min, max);
    }
}
