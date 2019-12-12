package com.wyy.microservicestudentconsumerhystrixturbine91;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableTurbine
public class MicroserviceStudentConsumerHystrixTurbine91Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentConsumerHystrixTurbine91Application.class, args);
    }

}
