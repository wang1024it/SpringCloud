package com.wyy.microservicestudentproviderhystrix.service.impl;

import com.wyy.microservicecommon.entity.Student;
import com.wyy.microservicestudentproviderhystrix.repository.StudentRepository;
import com.wyy.microservicestudentproviderhystrix.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findOne(id);
    }

    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    @Override
    public Map<String, Object> hystrix() {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 200);
        map.put("info","工号【"+port+"】正在为您服务");
        return map;
    }
}

