package com.top.demo.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @Author: lth
 * @Description:
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseResult implements Response {

    /**
     * 操作是否成功
     */
    boolean success = SUCCESS;

    /**
     * 操作代码
     */
    int code = SUCCESS_CODE;

    /**
     * 提示信息
     */
    String message;
    /**
     * 数据
     */
    Object obj;

    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }
    /**
     * 一般的http状态码及内容返回
     * @author lth
     * @param null
     * @return null
     */
    public ResponseResult(HttpStatus httpStatus){
        this.success = SUCCESS;
        this.code = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }

    public ResponseResult(ResultCode resultCode,Object obj){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.obj = obj;
    }

    public ResponseResult(int code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }

}
