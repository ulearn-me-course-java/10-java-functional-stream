package com.example.task05;

public interface MailServiceElement<T> {
    String getFrom();

    String getTo();

    T getContent();
}
