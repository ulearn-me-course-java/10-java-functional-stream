package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
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
        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
        stream.forEach(minMaxFinder);
        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
    }

    private static class MinMaxFinder<TItem> implements Consumer<TItem> {

        Comparator<? super TItem> order;

        boolean ifMinNull;
        TItem min;
        TItem max;

        private MinMaxFinder(Comparator<? super TItem> order) {
            this.order = order;
        }

        @Override
        public void accept(TItem value) {
            if (value == null) {
                min = null;
                ifMinNull = true;
                return;
            }
            if (!ifMinNull && min == null || order.compare(value, min) < 0) {
                min = value;
            }
            if (max == null || order.compare(value, max) > 0) {
                max = value;
            }
        }
    }
}
