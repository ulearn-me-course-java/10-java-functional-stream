package com.example.task05;

public class Salary implements  Server{
    private String from;
    private String to;
    private int content;
    public Salary(String from, String to, int content){
        this.from=from;
        this.to=to;
        this.content=content;
    }
    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Object getContent() {
        return content;
    }
}
