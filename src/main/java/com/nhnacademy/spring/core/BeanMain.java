package com.nhnacademy.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMain {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.spring.core")) {
            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);

            User user = new User("no name", "010-0000-0000");
            String message = "test2";

            service.doMessage(user, message);
        }
    }
}
