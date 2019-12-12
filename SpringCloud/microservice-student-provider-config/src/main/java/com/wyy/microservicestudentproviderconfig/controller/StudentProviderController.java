package com.wyy.microservicestudentproviderconfig.controller;

import com.wyy.microservicecommon.entity.Student;
import com.wyy.microservicestudentproviderconfig.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentProviderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/ribbon")
    public String ribbon(){
        return "工号【"+port+"】正在为您服务";
    }

    @Autowired
    private StudentService studentService;
     
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
}

