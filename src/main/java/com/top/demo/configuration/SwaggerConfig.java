package com.top.demo.configuration;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * * @description: Swagger文件
 * * @author: Tonghuan
 * * @create: 2019/3/21
 **/
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", value = "enable", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder builder = new ParameterBuilder();
        // 通用请求参数，通常为token
        List<Parameter> parameters = Lists.newArrayList();
        builder.name("Authorization").description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();
        parameters.add(builder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 匹配所有带Api注解的类
//                .apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.top.demo.modules"))
                .paths(PathSelectors.any())
                .build()
                // 为所有文档添加通用请求参数
                .globalOperationParameters(parameters);
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("top系统接口文档")
                .description("top系统接口文档")
                .termsOfServiceUrl("www.google.com")
                .contact("top开发人员联系方式:xxx")
                .version("1.0")
                .build();
    }

}
