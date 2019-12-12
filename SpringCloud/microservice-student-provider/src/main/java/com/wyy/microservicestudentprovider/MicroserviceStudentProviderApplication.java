package com.wyy.microservicestudentprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan("com.wyy.*.*")
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceStudentProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentProviderApplication.class, args);
    }

}
