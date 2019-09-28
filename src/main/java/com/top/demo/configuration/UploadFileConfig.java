package com.top.demo.configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
 * spring文件上传配置
 * @author Bufrosa
 * @version 1.0.0
 * @date 2019-05-29
 */
@Configuration
public class UploadFileConfig {

    /**
     * 设置spring上传文件配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = System.getProperty("user.home") + "/uploadFile";
        File tmp = new File(location);
        if (!tmp.exists()){
            tmp.mkdirs();
        }
        factory.setLocation(location);
        // 文件大小最大一律为5Mb
        factory.setMaxRequestSize(DataSize.ofMegabytes(5));
        factory.setMaxFileSize(DataSize.ofMegabytes(5));
        return factory.createMultipartConfig();
    }
}
