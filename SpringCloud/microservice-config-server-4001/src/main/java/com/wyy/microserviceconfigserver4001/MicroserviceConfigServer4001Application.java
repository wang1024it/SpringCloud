package com.wyy.microserviceconfigserver4001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MicroserviceConfigServer4001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigServer4001Application.class, args);
    }

}
