package com.softwaredeveloper.moviesservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MoviesServicesApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MoviesServicesApplication.class, args);
    }
}
