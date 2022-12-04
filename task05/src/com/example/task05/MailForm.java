package com.example.task05;

public abstract class MailForm<T> implements Form<T> {
    private String from;
    private String to;
    private T content;

    protected MailForm(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

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


}
