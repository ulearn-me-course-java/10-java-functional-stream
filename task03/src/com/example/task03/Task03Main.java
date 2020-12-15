package com.example.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main
{
    public static void main(String[] args)
    {
        findMinMax(Stream.of(2, 9, 5, 4, 8, 1, 3), Integer::compareTo,
                   (min, max) -> System.out.println("min: " + min + " / max: " + max));

    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer)
    {
        if (stream == null)
            throw new NullPointerException();
        Iterator<? extends T> iterator = stream.iterator();
        if (!iterator.hasNext())
        {
            minMaxConsumer.accept(null, null);
            return;
        }
        T el = iterator.next();
        T min = el, max = el;
        while (iterator.hasNext())
        {
            el = iterator.next();
            if (order.compare(el, min) < 0)
                min = el;
            if (order.compare(el, max) > 0)
                max = el;
        }
        minMaxConsumer.accept(min, max);
    }
}
