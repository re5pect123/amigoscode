package org.amigoscode;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(
        basePackages = "com.example.clients"
)
@EnableEurekaClient
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class, args);

    }
}