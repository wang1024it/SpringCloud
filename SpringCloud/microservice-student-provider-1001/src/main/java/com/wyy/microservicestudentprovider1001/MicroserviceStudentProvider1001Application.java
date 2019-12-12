package com.wyy.microservicestudentprovider1001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan("com.wyy.*.*")
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceStudentProvider1001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentProvider1001Application.class, args);
    }

}
