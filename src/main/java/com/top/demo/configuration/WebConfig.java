package com.top.demo.configuration;

import com.top.demo.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web应用基本配置
 * * @description:
 * * @author: Tonghuan
 * * @create: 2019/3/19
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;

    /**
     * 静态资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("").addResourceLocations("");
    }

    /**
     * 跨域处理
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("http://localhost:9000")
                .allowedMethods("GET", "POST", "PUT", "DELETE, PATCH");
    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/static/**");
    }
}
