package com.wyy.microservicestudentconsumerfeign80.controller;

import com.wyy.microservicecommon.entity.Student;
import com.wyy.microservicecommon.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentConsumerController {

    @Autowired
    private StudentClientService studentClientService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/save")
    private boolean save(Student student) {
        return studentClientService.save(student);
    }

    @GetMapping(value = "/list")
    public List<Student> list() {
        return studentClientService.list();
    }

    @GetMapping(value = "/get/{id}")
    public Student get(@PathVariable("id") Integer id) {
        return studentClientService.get(id);
    }

    @GetMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        try {
            studentClientService.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/ribbon")
    public String ribbon(){
        return studentClientService.ribbon();
    }

    /**
     * 测试Hystrix服务降级
     * @return
     */
    @GetMapping(value="/hystrix")
    @ResponseBody
    public Map<String,Object> hystrix(){
        return studentClientService.hystrix();
    }
}
