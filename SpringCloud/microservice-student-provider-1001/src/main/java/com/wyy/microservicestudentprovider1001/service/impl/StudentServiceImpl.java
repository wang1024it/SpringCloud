package com.wyy.microservicestudentprovider1001.service.impl;

import com.wyy.microservicecommon.entity.Student;
import com.wyy.microservicestudentprovider1001.repository.StudentRepository;
import com.wyy.microservicestudentprovider1001.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

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

}

