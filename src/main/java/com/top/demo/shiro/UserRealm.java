package com.top.demo.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.top.demo.common.response.CommonCode;
import com.top.demo.exception.ExceptionCast;
import com.top.demo.modules.pojo.RoleDO;
import com.top.demo.modules.pojo.RolePermissionDO;
import com.top.demo.modules.pojo.UserDO;
import com.top.demo.modules.service.RolePermissionService;
import com.top.demo.modules.service.RoleService;
import com.top.demo.modules.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author lth
 * @date 2019年10月17日 16:27
 */


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    RolePermissionService rolePermissionService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserDO userDO = (UserDO) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        QueryWrapper<RoleDO> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userDO.getuRole());
        RoleDO roleDO = roleService.getOne(wrapper);
        List<String> permissionCodes = Lists.newArrayList();
        if (roleDO != null) {
            info.addRole(roleDO.getName());
            permissionCodes =  rolePermissionService.listByRoleId(roleDO.getId());
        }
        info.addStringPermissions(permissionCodes);
        return info;

    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();

        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("u_user_name", username);
        UserDO user = userService.getOne(wrapper);
        if (user == null) {
            ExceptionCast.cast(CommonCode.USER_ERROR);
        }
        // 框架负责比对数据库中的密码和页面输入的密码是否一致
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getuPassword(), this.getName());
        return info;
    }
}
