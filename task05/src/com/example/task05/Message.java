package com.example.task05;

public class Message {
    String from;
    String to;
    String content;

    public Message(String from, String to, String content){
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

    public String getContent() {
        return content;
    }
}
