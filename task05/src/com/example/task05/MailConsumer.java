package com.example.task05;


public interface MailConsumer<T> {
    String getTo();

    T getContent();
}
