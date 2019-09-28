package com.top.demo.exception;

import com.top.demo.common.response.ResultCode;

/**
 * @author lth
 * @version 1.0.0
 * @date
 */

public class ExceptionCast {

    /**
     * 使用此静态方法抛出自定义异常
     * @author lth
     * @param  resultCode 错误代码
     * @return void
     */
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }

}
