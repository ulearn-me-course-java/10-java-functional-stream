package com.example.task05;

public class Message <T> {
    private final String from;
    private final String to;
    private final T content;

    public Message(String from, String to, T content){
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public T getContent() {
        return content;
    }
}