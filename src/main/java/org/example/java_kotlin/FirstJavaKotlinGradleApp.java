package org.example.java_kotlin;

import org.example.java_kotlin.config.TodoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TodoConfiguration.class)
public class FirstJavaKotlinGradleApp {

    public static void main(String[] args) {
        SpringApplication.run(FirstJavaKotlinGradleApp.class, args);
    }
}
