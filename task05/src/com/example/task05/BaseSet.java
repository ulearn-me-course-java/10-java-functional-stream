package com.example.task05;

public class BaseSet<T> {
    String firstElem;
    String secondElem;
    T content;

    public BaseSet(String from, String to, T content){
        this.firstElem = from;
        this.secondElem = to;
        this.content = content;
    }

    public String getTo(){
        return secondElem;
    }

    public String getFrom(){
        return firstElem;
    }

    public T getContent(){
        return content;
    }
}
