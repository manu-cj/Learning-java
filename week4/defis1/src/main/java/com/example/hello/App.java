package com.example.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            HelloService service = context.getBean(HelloService.class);
            System.out.println(service.getHelloMessage());
        }
    }
}
