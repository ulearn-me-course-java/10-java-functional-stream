package com.example.task05;

import java.util.SplittableRandom;

public class MailMessage extends Server<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
