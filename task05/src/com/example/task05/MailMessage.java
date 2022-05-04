package com.example.task05;



import java.util.Map;
import java.util.function.Consumer;

public class MailMessage implements Mail<String>
{
    private String from;
    private String to;
    private String message;

    public MailMessage(String from, String to, String message)
    {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public String getFrom()
    {
        return from;
    }

    public String getTo()
    {
        return to;
    }

    public String getContent()
    {
        return message;
    }

}
