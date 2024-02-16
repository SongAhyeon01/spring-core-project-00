package com.nhnacademy.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {
    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);

            User user = new User("no name", "010-0000-0000");
            String message = "test";

            service.doMessage(user, message);
        }

    }
}
