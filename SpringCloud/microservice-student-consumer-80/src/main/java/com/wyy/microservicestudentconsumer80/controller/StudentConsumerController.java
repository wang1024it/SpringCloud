package com.wyy.microservicestudentconsumer80.controller;

import com.wyy.microservicecommon.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentConsumerController {

    private final static String SERVER_IP_PORT = "http://MICROSERVICE-STUDENT";


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/save")
    private boolean save(Student student) {
        return restTemplate.postForObject(SERVER_IP_PORT + "/student/save", student, Boolean.class);
    }

    @GetMapping(value = "/list")
    public List<Student> list() {
        return restTemplate.getForObject(SERVER_IP_PORT + "/student/list", List.class);
    }

    @GetMapping(value = "/get/{id}")
    public Student get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(SERVER_IP_PORT + "/student/get/" + id, Student.class);
    }

    @GetMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        try {
            restTemplate.getForObject(SERVER_IP_PORT + "/student/delete/" + id, Boolean.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/ribbon")
    public String ribbon() {
        return restTemplate.getForObject(SERVER_IP_PORT + "/student/ribbon", String.class);
    }

    /**
     * 测试Hystrix服务降级
     * @return
     */
    @GetMapping(value="/hystrix")
    @ResponseBody
    public Map<String,Object> hystrix(){
        return restTemplate.getForObject(SERVER_IP_PORT+"/student/hystrix/", Map.class);
    }
}