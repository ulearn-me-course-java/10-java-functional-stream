package com.example.task05;

public class Content<T> {
    private final String to;
    private final String from;
    private final T content;

    public Content(String from, String to, T content) {
        this.to = to;
        this.from = from;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return from + " -> " + from + ": " + content;
    }
}
