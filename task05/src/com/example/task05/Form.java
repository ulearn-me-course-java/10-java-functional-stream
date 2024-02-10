package com.example.task05;

public interface Form<T> {
    String getFrom();
    String getTo();
    T getContent();
}