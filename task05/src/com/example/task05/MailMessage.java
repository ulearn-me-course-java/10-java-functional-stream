package com.example.task05;

public class MailMessage extends MailItem<String>{
    private Object from;
    private String to;
    private String content;

    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
