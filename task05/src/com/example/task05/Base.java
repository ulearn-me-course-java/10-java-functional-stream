package com.example.task05;

public abstract class Base<T> {
    String from;
    String to;
    T content;

    public Base(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public Base() {
        this.from = null;
        this.to = null;
        this.content = null;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public T getContent() {
        return this.content;
    }
}
