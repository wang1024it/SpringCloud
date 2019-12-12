package com.wyy.microservicestudentconsumerfeign80.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringCloudConfig {

    @LoadBalanced  // 引入ribbon负载均衡
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 自定义调用规则（服务提供者掉线后不再调用，解决轮询问题）
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RetryRule();
//        return new RandomRule();
    }
}
