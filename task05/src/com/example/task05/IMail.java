package com.example.task05;

public class IMail<T>
{
    private String from;
    private String to;
    private T content;

    public IMail(String from, String to, T content)
    {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom()
    {
        return from;
    }

    public String getTo()
    {
        return to;
    }

    public T getContent()
    {
        return content;
    }
}