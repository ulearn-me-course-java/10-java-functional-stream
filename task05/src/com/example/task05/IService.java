package com.example.task05;

public interface IService<T> {
    public T getContent();
    public String getFrom();
    public String getTo();
}
