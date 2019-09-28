package com.top.demo.exception;

import com.top.demo.common.response.ResultCode;

/**
 * 自定义异常
 * @author lth
 * @version 1.0.0
 * @date
 */

public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        // 异常信息为错误代码+异常信息
        super("错误代码：" + resultCode.code() + "错误信息：" + resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}
