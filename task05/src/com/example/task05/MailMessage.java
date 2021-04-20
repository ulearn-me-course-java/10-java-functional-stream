package com.example.task05;

public class MailMessage implements IMessage<String> {
    final private  String from;
    final private String to;
    final private String content;
    
    public MailMessage(String s1, String s2, String c){
        from = s1;
        to = s2;
        content = c;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public  String getContent() {
        return  content;
    }
}
