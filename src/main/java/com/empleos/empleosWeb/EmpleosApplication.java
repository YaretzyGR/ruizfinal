package com.empleos.empleosWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class EmpleosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleosApplication.class, args);
	}

}
