package com.nhnacademy.spring.core;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Qualifier;

public class DoorayMessageSender implements MessageSender {

    private final DoorayHookSender doorayHookSender;

    public DoorayMessageSender(@Qualifier("doorayHookSender") DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        doorayHookSender
                .send(DoorayHook.builder()
                        .botName(user.getName())
                        .text(message)
                        .build()
        );
        return true;
    }
}
