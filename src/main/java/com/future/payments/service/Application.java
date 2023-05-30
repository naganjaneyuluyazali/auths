package com.future.payments.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.Arrays;

@SpringBootApplication(scanBasePackages = {"com.future.payments.router", "com.future.payments.handler",
        "com.future.payments.exception", "com.future.payments.utils"})
public class Application {
    public static void main(String... args){
        try {
            ApplicationContext ctx = SpringApplication.run(Application.class, args);
            System.out.println("List of Beans instantiated");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
