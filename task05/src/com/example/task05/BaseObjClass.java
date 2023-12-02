package com.example.task05;

public class BaseObjClass<T> {
    private String From;
    private String To;
    private T Content;

    public BaseObjClass(String from, String to, T content){
        From = from;
        To = to;
        Content = content;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public T getContent() {
        return Content;
    }
}
