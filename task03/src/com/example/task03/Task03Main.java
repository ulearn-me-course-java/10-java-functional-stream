package com.example.task03;

import java.util.Comparator;
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
        MyOptional<T> first = new MyOptional<>(),
                last = new MyOptional<>();
        stream.forEach(x -> {
            if(!first.isPresent && first.get() == null || order.compare(x, first.get()) < 0) {
                first.set(x);
            }
            else if(last.get() == null || order.compare(x, last.get()) > 0) {
                last.set(x);
            }
        });
        minMaxConsumer.accept(first.get(), last.get());
    }

    private static class MyOptional<T> {
        private T value;
        public boolean isPresent;

        public T get() {
            return value;
        }

        public void set(T value) {
            this.value = value;
            isPresent = true;
        }
    }
}
