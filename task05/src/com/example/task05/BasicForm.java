package com.example.task05;

public class BasicForm<T> {
    String from;
    String to;
    T content;

    public BasicForm(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
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