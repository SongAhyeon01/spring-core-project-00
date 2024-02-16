package com.nhnacademy.spring.core;

public interface MessageSender {
    boolean sendMessage(User user, String message);
}
