package com.example.task05;

public class MailMessage {
    private String sender;
    private String reciever;
    private String text;
    public MailMessage(String sender, String reciever, String text){
        this.sender = sender;
        this.reciever = reciever;
        this.text = text;
    }
    public String getFrom(){
    return sender;
    }
    public String getTo(){
        return reciever;
    }
    public String getContent(){
        return text;
    }
}
