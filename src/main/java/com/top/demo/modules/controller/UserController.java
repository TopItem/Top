package com.top.demo.modules.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.google.common.collect.Maps;
import com.top.demo.api.UserControllerApi;
import com.top.demo.base.BaseController;
import com.top.demo.common.response.ResponseResult;
import com.top.demo.constant.BaseConst;
import com.top.demo.modules.pojo.UserDO;
import com.top.demo.utils.Md5Utils;
import com.top.demo.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.HashMap;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController implements UserControllerApi {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @RequestMapping("info")
    @RequiresPermissions("user:view")
    public ResponseResult info() {
       return renderSuccess(ShiroUtils.getLoginUser());
    }



    @Override
    @PostMapping(value = "login")
    public ResponseResult login(@RequestBody UserDO user) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(user.getuUserName(), Md5Utils.toMD5(user.getuPassword()));
        subject.login(token);
        UserDO userDO = (UserDO) subject.getPrincipal();
        Serializable id = subject.getSession().getId();
        HashMap<Object, Object> dataMap = Maps.newHashMap();
        dataMap.put("token", id);
        dataMap.put("user", userDO);
        redisTemplate.opsForValue().set(user.getuUserName(),id);
        return renderSuccess(dataMap);
    }
}

