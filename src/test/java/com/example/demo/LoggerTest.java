package com.example.demo;

import cn.hutool.core.codec.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * * @description: logger测试
 * * @author: Tonghuan
 * * @create: 2019/3/20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void test(){
        //System.out.println();

        //日志的级别；
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");

        String guest = Base64.encode("adminadmin");
        String string = Base64.decode("YWRtaW5hZG1pbg==","UTF-8").toString();
        System.out.println(string);

        System.out.println(guest);
    }


}
