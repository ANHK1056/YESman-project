package com.kosa.projectdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectBootApplication.class, args);
    }

}
