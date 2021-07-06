package com.coder.asimplemanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.Date;

@Data
@NoArgsConstructor

public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;     //0：女   1：男

    private Department department;
    private Date birthday;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birthday = new Date();         //默认的创建日期
    }
}
