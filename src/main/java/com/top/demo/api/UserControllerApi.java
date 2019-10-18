package com.top.demo.api;

import com.top.demo.common.response.ResponseResult;
import com.top.demo.modules.pojo.UserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * TestController接口
 *
 */
@Api(value="用户管理接口",description = "测试管理接口，提供页面的增、删、改、查")
public interface UserControllerApi {
    /**
     * 接口
     * @author lth
     * @date 2019/9/27 17:39
     * @return null
     */
    @ApiOperation("测试")
    ResponseResult info();

    @ApiOperation(value = "登录",code = 200,notes = "用户登录接口")
    ResponseResult login(UserDO user);
}
