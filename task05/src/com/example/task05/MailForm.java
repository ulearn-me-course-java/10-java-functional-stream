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

    @Override
    public T getContent() {
        return content;
    }

    protected MailForm(String from, String to, T salary) {
        this.from = from;
        this.to = to;
        this.content = salary;
    }
}