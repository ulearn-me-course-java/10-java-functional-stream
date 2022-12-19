package com.example.task05;

public class MailMessage extends MailContent<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}