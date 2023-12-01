package com.example.task05;

public class MailMessage extends Letter {
    private String content;
    public MailMessage(String from, String to, String content){
        super(from,to);
        this.content = content;
    }
    @Override
    public String getContent(){
        return content;
    }
}
