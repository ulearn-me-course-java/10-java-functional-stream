package com.example.task05;

public abstract class Frame<T> {

    String from;
    String to;
    T content;

    public Frame(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public Frame() {
        from = null;
        to = null;
        content = null;
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
