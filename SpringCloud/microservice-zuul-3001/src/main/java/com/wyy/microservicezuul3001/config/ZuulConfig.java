package com.wyy.microservicezuul3001.config;

import com.wyy.microservicezuul3001.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
