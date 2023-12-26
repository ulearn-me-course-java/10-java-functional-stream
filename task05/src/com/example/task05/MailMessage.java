package com.example.task05;

import org.assertj.core.util.diff.myers.Equalizer;

import javax.naming.Name;

public class MailMessage extends Message<String>{


    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}