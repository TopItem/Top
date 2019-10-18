package com.top.demo.utils;


import com.top.demo.modules.pojo.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Component;

/**
 * Shiro相关工具类
 *
 * @Author: lth
 * @Version 1.0
 */
@Component
public class ShiroUtils {

    private ShiroUtils() {
    }

    /**
     * 获取登录中的用户
     *
     * @return
     */
    public static UserDO getLoginUser() {
        Session session = SecurityUtils.getSubject().getSession();
        SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        if (principalCollection == null) {
            return null;
        }
        return (UserDO) principalCollection.getPrimaryPrincipal();
    }

}
