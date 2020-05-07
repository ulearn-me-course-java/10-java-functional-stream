package com.example.task05;

public class MailMessage implements Message<String>{
    private String from_whom;
    private String to_whom;
    private String text;

    public MailMessage (String from_whom, String to_whom, String text){
        this.from_whom = from_whom;
        this.to_whom = to_whom;
        this.text = text;
    }

    @Override
    public String getFrom() {
        return from_whom;
    }

    @Override
    public String getTo() {
        return to_whom;
    }

    @Override
    public String getContent() {
        return text;
    }
}
