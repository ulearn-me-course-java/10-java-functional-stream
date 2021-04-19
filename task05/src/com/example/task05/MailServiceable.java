package com.example.task05;

public abstract class MailServiceable<TContent> {
    private String from;
    private String to;
    private TContent content;

    public MailServiceable(String from, String to, TContent content) {
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

    public TContent getContent() {
        return content;
    }
}
