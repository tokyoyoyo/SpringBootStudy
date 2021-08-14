package com.coder;

import com.coder.bean.User;
import com.coder.mapper.UserMapper;

import jdk.management.resource.ResourceContextFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Springboot02WebApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads() {

        //        jdbcTemplate.queryForObject("select * from account_tbl")
//        jdbcTemplate.queryForList("select * from account_tbl",)
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        log.info("记录总数：{}",aLong);

        log.info("数据源类型：{}",dataSource.getClass());

    }

    @Autowired
    UserMapper userMapper;

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户信息： {}",user);
    }

//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Test
//    void testRedis(){
//        ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
//
//        stringValueOperations.set("hello","world");
//
//        String hello = stringValueOperations.get("hello");
//        //System.out.println(hello);
//
//        String s = stringValueOperations.get("/dynamic_table");
//        System.out.println(s);

        //System.out.println(redisConnectionFactory.getClass());
//    }

}
