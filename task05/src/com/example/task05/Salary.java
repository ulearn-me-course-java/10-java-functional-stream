package com.example.task05;

public class Salary implements Dispatched<Integer> {
    private String from, to ;
    private int content;

    public Salary(String from, String to, int content){
        this.content = content;
        this.from = from;
        this.to = to;
    }
    @Override
    public Integer getContent() {
        return content ;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }
}
