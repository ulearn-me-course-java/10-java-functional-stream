package com.example.task05;

public class Salary implements Mail<Integer>{

    private String from;
    private String to;
    private int content;

    public Salary(String From, String To, int Content){
        from = From;
        to = To;
        content = Content;
    }
    @Override
    public String getFrom(){
        return from;
    }

    @Override
    public String getTo(){
        return to;
    }

    @Override
    public Integer getContent(){
        return content;
    }
}
