package com.example.task05;

public class Message<T>{
    private final String from;
    private final String to;
    private final T value;

    public Message(String from, String to, T value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

    public T getContent() {
        return value;
    }
}
