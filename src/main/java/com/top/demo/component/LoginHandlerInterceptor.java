package com.top.demo.component;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.top.demo.common.response.CommonCode;
import com.top.demo.exception.ExceptionCast;
import com.top.demo.modules.pojo.UserDO;
import com.top.demo.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查，
 */
@Configuration

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String token = request.getHeader("Authorization");
        if(!StringUtils.isEmpty(token)) {
            // 不为空，说明不是登录，就判断是否挤下线
            UserDO loginUser = ShiroUtils.getLoginUser();
            if(loginUser == null) {
                // 未登录，放行
                return true;
            }
            String username = loginUser.getuUserName();
            // 获取redis中的token
            String redisToken = redisTemplate.opsForValue().get(username) + "";
            if(!token.equals(redisToken)) {
                // 不相同，说明有人在别处登录，挤下线
                ExceptionCast.cast(CommonCode.LOGOUT);
            }
        }

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
