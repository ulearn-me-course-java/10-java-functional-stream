package com.example.task05;

public class MailMessage extends Content<String> {
    public MailMessage(String fromAddress, String toAddress, String message) {
        super(fromAddress, toAddress, message);
    }
}
