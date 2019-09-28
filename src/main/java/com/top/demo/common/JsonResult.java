package com.top.demo.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lth
 * @version 1.0.0
 * @date
 */
@Data
public class JsonResult {


    // http 状态码
    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "成功";

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "响应数据", name = "success")
    private boolean success;

    /**
     * 返回的数据
     */
    @ApiModelProperty(value = "响应数据", name = "obj")
    private Object obj;

    @ApiModelProperty(value = "响应码", name = "status", required = true, example = "" + SUCCESS_CODE)
    private String status;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "响应消息", name = "msg", required = true, example = SUCCESS_MESSAGE)
    private String msg;



}