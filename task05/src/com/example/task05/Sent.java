package com.example.task05;

public interface Sent<T> {
    String getFrom();
    String getTo();
    T getContent();
}
