package com.example.task05;

public interface IEntry<T> {
    String getFrom();
    String getTo();
    T getContent();
}