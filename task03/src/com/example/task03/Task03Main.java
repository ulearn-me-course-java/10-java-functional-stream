package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
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


        T minn = iterator.next();
        T maxx = minn;


        while (iterator.hasNext()) {
            T curr = iterator.next();
            if (order.compare(curr, minn) < 0) {
                minn = curr;
            } else if (order.compare(curr, maxx) > 0) {
                maxx = curr;
            }
        }
        minMaxConsumer.accept(minn, maxx);


    }
}
