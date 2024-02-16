package com.nhnacademy.spring.core;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DoorayMessageSenderTest {

    @Mock
    DoorayHookSender doorayHookSender;

    @InjectMocks
    DoorayMessageSender doorayMessageSender;

    User testUser = new User("test user", "010-0000-0000");
    String message = "test message";

    @Test
    void sendMessage() {
        boolean result = doorayMessageSender.sendMessage(testUser, message);
        Mockito.verify(doorayHookSender, Mockito.times(1)).send(any(DoorayHook.class));
        Assertions.assertTrue(result);
    }
}