package com.example.task05;

public class Message<T> implements Sent<T> {

    private final String from;
    private final String to;
    private final T content;

    public Message(String from, String to, T content){
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return this.from;
    }

    @Override
    public String getTo(){
        return this.to;
    }

    @Override
    public T getContent() {
        return this.content;
    }
}
