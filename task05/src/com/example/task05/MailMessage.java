package com.example.task05;

public class MailMessage extends InfoKeeper<String> {
    public MailMessage(String to, String from, String content) {
        super(to, from, content);
    }
}