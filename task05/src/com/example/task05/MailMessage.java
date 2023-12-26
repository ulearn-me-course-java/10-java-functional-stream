package com.example.task05;

public class MailMessage<T> extends Content<T> {

    public MailMessage(String from, String to, T content) {
        super(from, to, content);
    }
}
