package com.scatch.scatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScatchApplication.class, args);
	}
}
