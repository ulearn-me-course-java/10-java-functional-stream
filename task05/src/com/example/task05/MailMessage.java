package com.example.task05;

import java.util.Arrays;

public class MailMessage<T> implements IFromToContent<String> {
    private String from, to, content;
    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }
}
