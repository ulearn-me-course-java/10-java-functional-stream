package com.example.task05;

public class MailMessage implements IMessage<String>{

    private String from;
    private String to;
    private String text;

    @Override
    public String getFrom() { return from; }

    @Override
    public String getTo() { return to; }

    @Override
    public String getContent() { return text; }

    public MailMessage(String from, String to, String content){
        this.from = from;
        this.to = to;
        text = content;
    }
}
