package com.wyy.microserviceconfigclient5001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
 
    @Value("${port}")
    private String port;
 
    @GetMapping("/getPort")
    public String getPort() {
        return "测试你访问的yml文件的端口是：【"+port+"】";
    }

}