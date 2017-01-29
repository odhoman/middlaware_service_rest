package com.anibal.educational.rest_service.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/** Luncher de la aplicacion */

@SpringBootApplication
public class RestServiceAplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestServiceAplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RestServiceAplication.class, args);
    }
    
}
