package com.example.task05;

public class MailMessage implements Mail<String>{

    private String from;
    private String to;
    private String content;

    public MailMessage(String From, String To, String Content){
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
    public String getContent(){
        return content;
    }
}
