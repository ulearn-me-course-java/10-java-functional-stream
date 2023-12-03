package com.example.task05;

public class Message<T> {
    String from;
    String to;
    T content;

    public Message(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public Message() {
        this.from = null;
        this.to = null;
        this.content = null;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public T getContent() {
        return this.content;
    }
}
