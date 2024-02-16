package com.nhnacademy.spring.core;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {

    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(restTemplate(), "https://hook.dooray.com/services/3204376758577275363/3738651962004364986/HByzZBRuRu69-EUTsWR0tg");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
