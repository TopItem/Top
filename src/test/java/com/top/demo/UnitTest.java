package com.top.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.top.demo.modules.mapper.RolePermissionMapper;
import com.top.demo.modules.pojo.RolePermissionDO;
import com.top.demo.modules.service.RolePermissionService;
import com.top.demo.modules.service.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lth
 * @date 2019年10月17日 19:57
 */
public class UnitTest {


    @Autowired
    RolePermissionService rolePermissionService;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    RoleService roleService;
    @Test
    public void test(){
//        List<String> strings =
//                rolePermissionService.listByRoleId(1);
//        System.out.println(strings);
        QueryWrapper<RolePermissionDO> query = new QueryWrapper<>();
        query.eq("role_id",1);
        List<RolePermissionDO> list = rolePermissionMapper.selectList(query);
    }

}
