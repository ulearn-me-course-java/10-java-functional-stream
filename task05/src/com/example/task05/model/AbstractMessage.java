package com.example.task05.model;

public abstract class AbstractMessage<T> {

    private final String from;

    public final String getFrom() {
        return from;
    }

    private final String to;

    public final String getTo() {
        return to;
    }

    public abstract T getContent();

    public AbstractMessage(String from, String to) {
        this.to = to;
        this.from = from;
    }
}
