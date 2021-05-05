package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Demo application.
 *
 * @author Sergei_Kornilov
 */
@SpringBootApplication
public class DemoApplication {

    //FYI: http://localhost:8080/swagger-ui/#/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
