package com.example.task05;

public class Mail<T> {
    private final String from;
    private final String to;
    private final T content;

    protected Mail(String from, String to, T content){
        this.content = content;
        this.to = to;
        this.from = from;

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
}
