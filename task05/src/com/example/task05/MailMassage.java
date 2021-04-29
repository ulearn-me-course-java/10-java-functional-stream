package com.example.task05;

class MailMessage extends MailParcel<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}