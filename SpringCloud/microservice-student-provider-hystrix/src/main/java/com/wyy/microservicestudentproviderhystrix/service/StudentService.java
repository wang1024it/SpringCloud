package com.wyy.microservicestudentproviderhystrix.service;


import com.wyy.microservicecommon.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
 
    public void save(Student student);
     
    public Student findById(Integer id);
     
    public List<Student> list();
     
    public void delete(Integer id);

    /**
     * 测试Hystrix服务降级
     * @return
     */
    public Map<String,Object> hystrix();
     
}

