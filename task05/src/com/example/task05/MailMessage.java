package com.example.task05;

class MailMessage extends ContentContainer<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}