package com.wyy.microservicestudentproviderhystrix1004.service;


import com.wyy.microservicecommon.entity.Student;

import java.util.List;

public interface StudentService {
 
    public void save(Student student);
     
    public Student findById(Integer id);
     
    public List<Student> list();
     
    public void delete(Integer id);
     
     
}

