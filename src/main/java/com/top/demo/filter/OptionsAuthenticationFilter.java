package com.top.demo.filter;

import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 重写shiro过滤器，自动放行OPTIONS请求
 *
 * @version 1.0
 * @author: lth
 */
public class OptionsAuthenticationFilter extends PassThruAuthenticationFilter {

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        return super.onPreHandle(request, response, mappedValue);
    }
}
