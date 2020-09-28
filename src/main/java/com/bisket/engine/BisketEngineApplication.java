package com.bisket.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BisketEngineApplication {
    public static void main(String[] args) {
        SpringApplication.run(BisketEngineApplication.class, args);
    }
}
