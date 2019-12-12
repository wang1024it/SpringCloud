package com.wyy.microservicestudentconsumerfeign80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.wyy.microservicecommon","com.wyy.microservicestudentconsumerfeign80"})
@EnableEurekaClient
@EnableFeignClients(value = "com.wyy.*.*")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MicroserviceStudentConsumerFeign80Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentConsumerFeign80Application.class, args);
    }

}
