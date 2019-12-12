package com.wyy.microservicestudentproviderhystrix1004.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyy.microservicecommon.entity.Student;
import com.wyy.microservicestudentproviderhystrix1004.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentProviderController {
 
    @Autowired
    private StudentService studentService;
    @Value("${server.port}")
    private String port;
     
    @PostMapping(value="/save")
    public boolean save(Student student){
        try{
            studentService.save(student);  
            return true;
        }catch(Exception e){
            return false;
        }
    }
     
    @GetMapping(value="/list")
    public List<Student> list(){
        return studentService.list();
    }
     
    @GetMapping(value="/get/{id}")
    public Student get(@PathVariable("id") Integer id){
        return studentService.findById(id);
    }
     
    @GetMapping(value="/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        try{
            studentService.delete(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @RequestMapping("/ribbon")
    public String ribbon(){
        return "工号【"+port+"】正在为您服务";
    }

    /**
     * 测试Hystrix服务降级
     * @return
     * @throws InterruptedException
     */
    @ResponseBody
    @GetMapping(value="/hystrix")
    @HystrixCommand(fallbackMethod="hystrixFallback")
    public Map<String,Object> hystrix() throws InterruptedException{
        Thread.sleep(4000);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 200);
        map.put("info","工号【"+port+"】正在为您服务");
        return map;
    }
    public Map<String,Object> hystrixFallback() throws InterruptedException{
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 500);
        map.put("info", "系统【"+port+"】繁忙，稍后重试");
        return map;
    }
}
