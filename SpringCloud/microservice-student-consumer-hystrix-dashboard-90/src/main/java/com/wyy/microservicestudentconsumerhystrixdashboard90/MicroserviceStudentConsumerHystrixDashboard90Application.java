package com.wyy.microservicestudentconsumerhystrixdashboard90;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MicroserviceStudentConsumerHystrixDashboard90Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentConsumerHystrixDashboard90Application.class, args);
    }

}
