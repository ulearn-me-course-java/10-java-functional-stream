package com.example.task05;

public class MailMessage implements IService<String>{
    private String from, to, content;

    public MailMessage(String from, String to, String content){
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }
}
