package com.rosualexandru.disertatie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.rosualexandru.disertatie")
public class DisertatieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisertatieApplication.class, args);
	}

}
