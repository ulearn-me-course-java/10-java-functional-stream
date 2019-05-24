package com.example.task04;

import java.util.concurrent.atomic.AtomicInteger;

public class ComparableInt extends AtomicInteger implements Comparable<AtomicInteger> {
    public ComparableInt(int i) {
        super(i);
    }

    @Override
    public int compareTo(AtomicInteger o) {
        return Integer.compare(this.get(), o.get());
    }
}
