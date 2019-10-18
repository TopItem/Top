package com.top.demo.modules.service.impl;

import com.top.demo.modules.pojo.UserDO;
import com.top.demo.modules.mapper.UserMapper;
import com.top.demo.modules.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
