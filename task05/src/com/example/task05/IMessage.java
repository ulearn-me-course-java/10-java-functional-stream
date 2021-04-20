package com.example.task05;

public interface IMessage<T> {

    public String getFrom();

    public String getTo();

    public T getContent();
}
