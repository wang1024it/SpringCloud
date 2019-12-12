package com.wyy.microservicestudentproviderconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan("com.wyy.*.*")
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceStudentProviderConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentProviderConfigApplication.class, args);
    }

}
