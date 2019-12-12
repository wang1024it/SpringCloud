package com.wyy.microservicestudentproviderhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EntityScan("com.wyy.*.*")
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceStudentProviderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentProviderHystrixApplication.class, args);
    }

}
