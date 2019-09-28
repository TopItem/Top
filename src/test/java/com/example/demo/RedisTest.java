package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * * @description:
 * * @author: Tonghuan
 * * @create: 2019/3/19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate; // 存的是的对象

    @Autowired
    private StringRedisTemplate stringRedisTemplate; // 存的是字符串

    @Test
    public void test(){

    }

}
