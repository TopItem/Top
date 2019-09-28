package com.top.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * * @description: redisTemplate 用来进行redis的操作
 * * @author: Tonghuan
 * * @create: 2019/3/19
 **/
@Configuration
public class RedisConfiguration {

    /**
     *功能描述 自定义序列化转换器,默认是jdk的,这儿把他转换为java
     * @author lth
     * @param
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.Object,java.lang.Object>
     */
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> ser = new Jackson2JsonRedisSerializer<Object>(Object.class);
        template.setDefaultSerializer(ser);
        return template;
    }
    /**
     *功能描述 操作的是string
     * @author lth
     * @param
     * @return org.springframework.data.redis.core.StringRedisTemplate
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }

}
