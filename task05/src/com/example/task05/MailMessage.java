package com.example.task05;

import com.example.task05.MailContent;

public class MailMessage extends MailContent<String> {
    public MailMessage(String from, String to, String message) {
        super(from, to, message);
    }
}