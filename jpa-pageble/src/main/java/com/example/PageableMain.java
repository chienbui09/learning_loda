package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class PageableMain {
    public static void main(String[] args) {
        SpringApplication.run(PageableMain.class,args);
    }
}