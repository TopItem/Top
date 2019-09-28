package com.top.demo.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * * @description: mybatis的配置文件
 * * @author: Tonghuan
 * * @create: 2019/3/25
 **/
@Configuration
@MapperScan(basePackages = {"com.top.demo.modules.admin.dao"})
public class MyBatisConfig {


        private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

        /**
         * 功能描述 mybatisPlus的一个分页类
         * @author lth
         */
        @Bean
        public PaginationInterceptor paginationInterceptor(){
                return new PaginationInterceptor();
        }

}
