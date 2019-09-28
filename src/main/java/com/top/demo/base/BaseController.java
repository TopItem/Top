package com.top.demo.base;

import com.top.demo.common.response.CommonCode;
import com.top.demo.common.response.ResponseResult;

/**
 * 渲染数据
 * @author lth
 * @version 1.0.0
 * @date
 */

public class BaseController {

    /**
     * 渲染失败数据
     */
    protected ResponseResult renderError(){
        return new ResponseResult(CommonCode.FAIL);
    }
    /**
     * 渲染成功数据（带数据）
     */
    protected  ResponseResult renderError(Object obj){
        return new ResponseResult(CommonCode.FAIL,obj);
    }

    /**
     * 渲染成功数据
     */
    protected ResponseResult renderSuccess(){
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 渲染成功数据（带数据）
     */
    protected  ResponseResult renderSuccess(Object obj){
        return new ResponseResult(CommonCode.SUCCESS,obj);
    }
}
