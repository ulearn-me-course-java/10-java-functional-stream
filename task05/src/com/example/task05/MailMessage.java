package com.example.task05;

public class MailMessage implements Message<String> {
    private final String from;
    private final String to;
    private final String message;

    public MailMessage (String from, String to, String message){
        this.from = from;
        this.to = to;
        this.message = message;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getContent() {
        return message;
    }
}
