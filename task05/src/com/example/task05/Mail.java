package com.example.task05;

public class Mail<T> {
    private final String From , To;
    private final T Content;

    public Mail(String from, String to, T content){
        From = from;
        To = to;
        Content = content;
    }

    public String getFrom(){
        return From;
    }

    public String getTo(){
        return To;
    }

    public T getContent(){
        return Content;
    }
}
