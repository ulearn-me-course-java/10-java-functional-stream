package com.example.task05;

public class MailContent<T> implements  Content<T>{
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

    protected MailContent(String from, String to, T salary) {
        this.from = from;
        this.to = to;
        this.content = salary;
    }
}
