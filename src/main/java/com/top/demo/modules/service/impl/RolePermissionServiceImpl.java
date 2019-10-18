package com.top.demo.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.top.demo.modules.mapper.PermissionMapper;
import com.top.demo.modules.pojo.PermissionDO;
import com.top.demo.modules.pojo.RolePermissionDO;
import com.top.demo.modules.mapper.RolePermissionMapper;
import com.top.demo.modules.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色资源表 服务实现类
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermissionDO> implements RolePermissionService {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public List<String> listByRoleId(Integer id) {
        QueryWrapper<RolePermissionDO> query = new QueryWrapper<>();
        query.eq("role_id",id);
        List<RolePermissionDO> list = rolePermissionMapper.selectList(query);
        // 得到该角色对应的permission的ids
        List<Integer> permissionIds = list.stream().map(RolePermissionDO::getPermissionId).collect(Collectors.toList());

        List<PermissionDO> permissionDOS = permissionMapper.selectBatchIds(permissionIds);
        return permissionDOS.stream().map(PermissionDO::getPerCode).collect(Collectors.toList());
    }
}