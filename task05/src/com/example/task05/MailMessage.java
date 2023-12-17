package com.example.task05;

public class MailMessage extends AbstractMessage<String> {

    private final String content;

    @Override
    public String getContent() {
        return content;
    }

    public MailMessage(String from, String to, String message) {
        super(from, to);
        this.content = message;
    }
}
