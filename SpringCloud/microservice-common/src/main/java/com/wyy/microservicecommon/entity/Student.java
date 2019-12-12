package com.wyy.microservicecommon.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_springCloud_student")
public class Student implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue
    private Integer id;
     
    @Column(length=50)
    private String name;
     
    @Column(length=50)
    private String grade;
     
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
     
     
     
}

