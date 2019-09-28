package com.top.demo.common.response;

import lombok.ToString;

/**
 * @author lth
 * @date 2019年09月27日 20:17
 */

@ToString
public enum UserCode implements ResultCode {



    SUCCESS(true,10000,"操作成功！"),
    ACCOUNT_IS_EMPTY(false,11111,"账号为空"),
    USER_NOT_EXIT(false,11111,"用户不存在！"),
    MSG_ERROR(false,11111,"账号或密码错误"),
    TOKEN_OVERDUE(false,11111,"token已过期");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private UserCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}
