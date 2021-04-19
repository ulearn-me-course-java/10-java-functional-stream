package com.example.task05;

public abstract class IService<T> {
    private String from;
    private String to;
    private T contentValue;

    public IService(String from, String to, T value) {
        this.from = from;
        this.to = to;
        this.contentValue = value;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return contentValue;
    }
}
