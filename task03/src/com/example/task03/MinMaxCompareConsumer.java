package com.example.task03;

import java.util.Comparator;
import java.util.function.Consumer;

public class MinMaxCompareConsumer <T> implements Consumer<T> {

    Comparator<? super T> order;

    T min;

    T max;

    boolean isStart = true;

    public MinMaxCompareConsumer(Comparator<? super T> order) {
        this.order = order;
    }

    @Override
    public void accept(T element) {

        if (isStart) {
            isStart = false;
            min = element;
            max = element;
            return;
        }
        min = order.compare(min, element) >= 0 ? element : min;
        max = order.compare(max, element) >= 0 ? max : element;
    }
}