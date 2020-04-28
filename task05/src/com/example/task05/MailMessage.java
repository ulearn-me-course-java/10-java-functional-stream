package com.example.task05;

public class MailMessage implements MailContainer <String>{

    String from;

    String to;

    String content;

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getMessage() {
        return content;
    }
}
