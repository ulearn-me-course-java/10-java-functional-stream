package com.example.task05;

public interface Dispatched<T> {
    public T getContent();

    public String getFrom();

    public String getTo();
}
