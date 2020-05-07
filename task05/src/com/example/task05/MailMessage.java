package com.example.task05;

public class MailMessage extends Message<String> {
    private String author;
    private String to;
    private String content;

    public MailMessage(String author, String to, String content) {
        super(author, to, content);
    }
}