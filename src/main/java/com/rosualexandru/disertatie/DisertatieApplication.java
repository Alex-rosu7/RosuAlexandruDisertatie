package com.rosualexandru.disertatie;

import com.rosualexandru.disertatie.Config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.rosualexandru.disertatie")
@EnableConfigurationProperties(RsaKeyProperties.class)
public class DisertatieApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisertatieApplication.class, args);
    }

}
