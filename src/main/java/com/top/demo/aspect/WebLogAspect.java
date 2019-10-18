package com.top.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 日志配置
 * @author litonghuan
 */
@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 扫描所有模块的controller
     */
    @Pointcut("execution( * com.top.demo.modules.controller.*.*(..))")
    public void logPointCut() {
    }


    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        logger.debug("返回值 : " + ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }
}
