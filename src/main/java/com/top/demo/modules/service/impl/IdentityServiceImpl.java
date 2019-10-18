package com.top.demo.modules.service.impl;

import com.top.demo.modules.pojo.IdentityDO;
import com.top.demo.modules.mapper.IdentityMapper;
import com.top.demo.modules.service.IdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 身份验证表 服务实现类
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@Service
public class IdentityServiceImpl extends ServiceImpl<IdentityMapper, IdentityDO> implements IdentityService {

}
