package com.nhnacademy.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageSendService {

    private final MessageSender messageSender;

    @Autowired
    public MessageSendService(@Qualifier("doorayMessageSender") MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }
}
