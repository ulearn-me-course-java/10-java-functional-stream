package com.example.task05;

public class MailMessage implements IMessage<String>{

    private String _from;
    private String _to;
    private String _text;

    @Override
    public String getFrom() { return _from; }

    @Override
    public String getTo() { return _to; }

    @Override
    public String getContent() { return _text; }

    public MailMessage(String from, String to, String content){
        _from = from;
        _to = to;
        _text = content;
    }
}
