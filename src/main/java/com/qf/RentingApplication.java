package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qf.dao")
public class RentingApplication {

    public static void main(String[] args) {

        SpringApplication.run(RentingApplication.class);
    }

}
