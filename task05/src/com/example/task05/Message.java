package com.example.task05;

public interface Message<T> {
    String getFrom();
    String getTo();
    T getContent();

    //еще можно было вместо данного интерфейса сделать абстрактный класс,
    //тогда кода в Salary и MailMessage станет меньше.
    //мне так больше понравилось, поэтому оставила через интерфейс))
}
