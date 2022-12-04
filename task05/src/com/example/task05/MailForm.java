package com.example.task05;

public abstract class MailForm<T> implements Form<T> {
    private final String from;
    private final String to;
    private final T content;

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }

    public MailForm(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }
}
