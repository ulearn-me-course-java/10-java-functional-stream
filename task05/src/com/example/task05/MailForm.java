package com.example.task05;

public abstract class MailForm<T> {
    private final String from;
    private final String to;

    protected MailForm(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public abstract T getContent();
}