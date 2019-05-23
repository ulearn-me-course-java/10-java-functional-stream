package com.example.task05;

public interface Server<T>{
    public String getFrom();
    public String getTo();
    public T getContent();
}
