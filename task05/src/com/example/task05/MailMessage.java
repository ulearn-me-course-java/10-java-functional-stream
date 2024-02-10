package com.example.task05;

public class MailMessage extends MailForm<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}