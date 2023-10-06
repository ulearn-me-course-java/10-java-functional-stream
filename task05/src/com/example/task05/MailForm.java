package com.example.task05;

public abstract class MailForm<T> {
    private final String from;
    private final String to;
    private final T content;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }

    protected MailForm(String from, String to, T salary) {
        this.from = from;
        this.to = to;
        this.content = salary;
    }
}