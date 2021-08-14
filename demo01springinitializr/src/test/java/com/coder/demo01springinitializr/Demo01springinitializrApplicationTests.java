package com.coder.demo01springinitializr;

import com.coder.demo01springinitializr.pojo.Dog;
import com.coder.demo01springinitializr.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo01springinitializrApplicationTests {

    @Autowired
    private Dog dog;

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person + "\n" +dog);
    }

}
