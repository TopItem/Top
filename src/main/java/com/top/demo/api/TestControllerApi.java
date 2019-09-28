package com.top.demo.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * TestController接口
 *
 */
@Api(value="测试管理接口",description = "测试管理接口，提供页面的增、删、改、查")
public interface TestControllerApi {
    /**
     * 接口
     * @author lth
     * @date 2019/9/27 17:39
     * @return null
     */
    @ApiOperation("测试")
    String hello();
}
