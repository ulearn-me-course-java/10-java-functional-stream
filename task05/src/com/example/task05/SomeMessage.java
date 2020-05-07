package com.example.task05;

public abstract class SomeMessage<T> implements IMessage<T> {
    private String from;
    private String to;
    private T content;

    public SomeMessage(String from, String to, T content){
        this.from=from;
        this.to=to;
        this.content = content;
    }

    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

    public T getContent(){
        return content;
    }
}
