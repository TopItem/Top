package com.top.demo.configuration;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * * @description: RabbitMq配置
 * * @author: Tonghuan
 * * @create: 2019/3/20
 **/
@Configuration
public class RabbitMQConfig {

    /**
     *功能描述 自定义序列化转换器,默认的是jdk的,这里把它转换为json的
     * @author lth
     * @param
     * @return org.springframework.amqp.support.converter.MessageConverter
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
