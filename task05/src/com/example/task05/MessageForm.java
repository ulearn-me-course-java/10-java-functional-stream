package com.example.task05;

public interface MessageForm<T> {
    String getFrom();
    String getTo();
    T getContent();
}
