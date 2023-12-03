package com.example.task05;

public interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}