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

        Iterator<? extends T> iterator = stream.iterator(); // получаем итератор потока
        T current = iterator.hasNext() ? iterator.next() : null; // возвращаем null, если пусто
        T min = current; // инициализируем минимальный и максимальный элементы
        T max = current;
        while (iterator.hasNext()) { // проходим по элементам, переназначая min max в зависимости от значения
                                     // текущего элемента
            current = iterator.next();
            if (order.compare(current, min) < 0) {
                min = current;
            } else if (order.compare(current, max) > 0) {
                max = current;
            }
            // compare вернет значение < 0, если current меньше min, и > 0, если иначе.
        }
        minMaxConsumer.accept(min, max);
    }
}
