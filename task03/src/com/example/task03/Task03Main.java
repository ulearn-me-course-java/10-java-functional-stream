package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
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

        Object[] min = new Object[]{null};
        Object[] max = new Object[]{null};
        Iterator<? extends T> iter = stream.iterator();

        if (iter.hasNext()) {
            T val = iter.next();
            min[0] = val;
            max[0] = val;
        }

        iter.forEachRemaining(x -> {
            if (order.compare(x, (T) min[0]) < 0) min[0] = x;
            if (order.compare(x, (T) max[0]) > 0) max[0] = x;
        });

        minMaxConsumer.accept((T) min[0], (T) max[0]);
    }
}
