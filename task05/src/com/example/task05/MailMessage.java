package com.example.task05;

public class MailMessage extends MailServiceable<String> {
    public MailMessage(String from, String to, String s) {
        super(from, to, s);
    }
}
