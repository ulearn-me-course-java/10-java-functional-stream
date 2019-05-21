package com.example.task05;

public interface Mail <T> {
    public String getFrom();

    public String getTo();

    public T getContent();
}
