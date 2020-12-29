package com.swb.studyonline.result;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@ToString
public enum ResultCode {

    SUCCESS(true,200,"操作成功！"),
    ERROR(false,500,"操作失败！"),
    DYNAMIC_MSG(false,999,""),
    NO_LOGIN(false,1001,"用户未登录！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UN_AUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    REDIS_ERROR(false,99999,"redis错误"),
    ;
//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private ResultCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }
    public int code() {
        return code;
    }

    public String message() {
        return message;
    }


}
