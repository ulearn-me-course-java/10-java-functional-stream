package com.example.task05;

public class MailMessage implements Message<String> {
    private final String from;

    @Override
    public String getFrom(){
        return from;
    }

    private final String to;

    @Override
    public String getTo() {
        return to;
    }

    private final String content;

    @Override
    public String getContent(){
        return content;
    }

    public MailMessage(String from, String to, String content){
        this.from = from;
        this.to = to;
        this.content = content;
    }
}
