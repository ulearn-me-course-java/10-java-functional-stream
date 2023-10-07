package com.example.task05;

public abstract class Letter <T> {
    private String from;
    private String to;
    public Letter(String from,String to){
        this.from = from;
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public String getTo(){
        return to;
    }
    public abstract T getContent();
}
