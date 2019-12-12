package com.wyy.microservicestudentproviderhystrix1004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EntityScan("com.wyy.*.*")
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceStudentProviderHystrix1004Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentProviderHystrix1004Application.class, args);
    }
}
