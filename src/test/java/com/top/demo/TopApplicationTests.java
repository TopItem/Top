package com.top.demo;

import java.time.LocalDateTime;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.top.demo.modules.mapper.RolePermissionMapper;
import com.top.demo.modules.mapper.UserMapper;
import com.top.demo.modules.pojo.RolePermissionDO;
import com.top.demo.modules.pojo.UserDO;
import com.top.demo.modules.service.RolePermissionService;
import com.top.demo.modules.service.RoleService;
import com.top.demo.modules.service.UserService;
import com.top.demo.utils.Md5Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * @author lth
 * @date 2019年10月17日 20:22
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopApplicationTests {


    @Autowired
    RolePermissionService rolePermissionService;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Test
    public void test() {
        List<String> strings =
                rolePermissionService.listByRoleId(1);
        System.out.println(strings);
    }

    @Test
    public void addUser() {
        for (int i = 0; i < 1000; i++) {
            UserDO userDO = new UserDO();
            userDO.setuUserName("赵四" + i);
            userDO.setuPassword(Md5Utils.toMD5("123"));
            userDO.setuSpecialty(1);
            userDO.setuPhone("18670138519");
            userDO.setuProfile("http://static.oschina.net/uploads/space/2014/0404/070043_sXky_12.png");
            userDO.setuSex(1);
            userDO.setuDegree(23);
            userDO.setuStatus(0);
            userDO.setuRole(0);
            userDO.setuEmail("www.852172031@qq.com");
            userDO.setCreateTime(LocalDateTime.now());
            userDO.setUpdateTime(LocalDateTime.now());
            Assert.assertTrue(userService.save(userDO));
            userService.save(userDO);
        }

    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void testPageHelper() {
        PageHelper.startPage(2, 4);

        Page<UserDO> page = userMapper.findUserListPage();
        List<UserDO> result = page.getResult();
        for (UserDO userDO : result) {
            System.out.println(userDO);
        }
        com.top.demo.base.Page<UserDO> pages = new com.top.demo.base.Page<>();
        pages.setList(page.getResult());
        pages.setPageSize(page.getPageSize());
        pages.setPageNum(page.getPageNum());
        pages.setTotal(page.getTotal());
        System.out.println(JSONUtil.toJsonStr(pages));

    }


}
