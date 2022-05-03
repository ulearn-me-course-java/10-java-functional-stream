package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3), // отправляем поток
                Integer::compareTo, // отправляем ссылку на метод compareTo
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max) // отправляем Consumer
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {


        Iterator<? extends T> iterator = stream.iterator(); //? super t - показывает что мы примем лишь тип t и его родителей U отправим его или родителей
        if (!iterator.hasNext()) { // если в итерируемом объекте остались еще значение — метод вернет true, если значения кончились false.
            minMaxConsumer.accept(null, null); // пусто вывести 0 и 0
            return;
        }
        T next = iterator.next();
        T min = next;
        T max = next;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (order.compare(min, next) > 0)
                min = next;
            if (order.compare(max, next) < 0)
                max = next;
        }
        minMaxConsumer.accept(min, max); // выполнить действие и показать наибольшое и наименьшое
    }
}
