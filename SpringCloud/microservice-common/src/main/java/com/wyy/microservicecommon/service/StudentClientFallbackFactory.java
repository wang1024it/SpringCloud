package com.wyy.microservicecommon.service;

import com.wyy.microservicecommon.entity.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义回退方法
 */

@Component
public class StudentClientFallbackFactory implements FallbackFactory<StudentClientService> {

    @Override
    public StudentClientService create(Throwable cause) {
        return new StudentClientService() {

            @Override
            public boolean save(Student student) {
                return false;
            }

            @Override
            public List<Student> list() {
                return null;
            }

            @Override
            public Map<String, Object> hystrix() {
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("code", 500);
                map.put("info", "系统繁忙，稍后重试");
                return map;
            }

            @Override
            public Student get(Integer id) {
                return null;
            }

            @Override
            public boolean delete(Integer id) {
                return false;
            }

            @Override
            public String ribbon() {
                return null;
            }
        };
    }

}