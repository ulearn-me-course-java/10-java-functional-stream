package com.example.task05;

public class MailParcel<T> {
    private final String from, to;
    private final T content;

    public MailParcel(String from, String to, T content) {
        this.from = from;
        this.to = to;
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
}
