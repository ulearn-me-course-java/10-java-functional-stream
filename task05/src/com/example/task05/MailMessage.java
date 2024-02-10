package com.example.task05;
import java.util.ArrayList;
import java.util.List;

public class MailMessage extends Message <String> {
    public MailMessage(String from, String to, String content){
        super(from, to, content);
    }
}