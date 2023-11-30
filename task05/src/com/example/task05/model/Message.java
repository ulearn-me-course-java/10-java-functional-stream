package com.example.task05.model;

public interface Message<T> {
    String getFrom();
    String getTo() ;
    T  getContent();
}
