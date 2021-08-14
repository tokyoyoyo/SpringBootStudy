package com.coder.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    @TableField(exist = false)
    private String password;
    private Integer age;
    private String email;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
