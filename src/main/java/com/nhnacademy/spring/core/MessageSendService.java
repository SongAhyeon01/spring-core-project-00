package com.nhnacademy.spring.core;

public class MessageSendService {

    private final MessageSender messageSender;

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }
}
