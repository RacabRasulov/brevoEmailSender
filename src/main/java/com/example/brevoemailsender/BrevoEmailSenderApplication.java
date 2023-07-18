package com.example.brevoemailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BrevoEmailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrevoEmailSenderApplication.class, args);
    }

}
