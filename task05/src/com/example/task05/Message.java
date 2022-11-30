package com.example.task05;

public abstract class Message<T> implements IMessage<T> {
    String from;
    String to;
    T content;

    public Message(String from, String to, T content) {
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
