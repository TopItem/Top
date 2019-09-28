package com.top.demo.modules.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.top.demo.exception.CustomException;
import com.top.demo.modules.admin.pojo.DO.User;
import com.top.demo.modules.admin.dao.TestMapper;
import com.top.demo.modules.admin.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lth
 * @date 2019年09月27日 17:57
 */

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper,User> implements TestService  {

    @Transactional(rollbackFor = CustomException.class)
    @Override
    public void add(User user) {
        this.save(user);
    }

    @Override
    public User selectOne(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("num",user.getNum());
        return this.getOne(queryWrapper);
    }
}
