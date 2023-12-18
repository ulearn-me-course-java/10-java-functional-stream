package com.example.task05;
import java.util.ArrayList;
import java.util.List;

public class MailMessage<T> {
    public static List<MailMessage> messages;
    String from;
    String to;
    T content;

    public MailMessage(String from, String to, T content){
        this.from = from;
        this.to = to;
        this.content = content;
        if(messages == null) messages = new ArrayList<>();
        messages.add(this);
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
