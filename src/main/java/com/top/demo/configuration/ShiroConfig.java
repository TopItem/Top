package com.top.demo.configuration;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.top.demo.constant.RedisConstant;
import com.top.demo.filter.OptionsAuthenticationFilter;
import com.top.demo.manager.MySessionManager;
import com.top.demo.shiro.UserRealm;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lth
 * @date 2019年10月17日 16:33
 */

@Configuration
public class ShiroConfig {


    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        System.out.println("==================ShiroFilterFactoryBean====================");
        // 设置安全管理器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 配置自定义shiro过滤器
        Map<String, Filter> optionsFilter = Maps.newHashMap();
        OptionsAuthenticationFilter authenticationFilter = new OptionsAuthenticationFilter();
        optionsFilter.put("authc", authenticationFilter);
        shiroFilterFactoryBean.setFilters(optionsFilter);
        shiroFilterFactoryBean.setLoginUrl("/user/login");

        /**
         * 常用过滤器
         *  anon：无需认证可以访问
         *  authc：必须认证才能访问
         *  user：如果使用rememberMe的功能可以直接访问
         *  perms：该资源必须得到权限才可以访问
         *  role：该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = Maps.newHashMap();
        filterMap.put("/user/login", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultSecurityManager
     */
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        // 加入认证器
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 自定义sessionManager
     */
    @Bean("sessionManager")
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        mySessionManager.setGlobalSessionTimeout(RedisConstant.EXRP_HOUR * 1000);
        return mySessionManager;
    }


    /**
     * 创建Realm
     */
    @Bean("userRealm")
    public UserRealm examRealm() {
        return new UserRealm();
    }

    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
