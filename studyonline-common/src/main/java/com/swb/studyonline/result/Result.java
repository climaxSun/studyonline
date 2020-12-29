package com.swb.studyonline.result;

/**
 * <p>文件  Result</p>
 * <p>时间  2020-12-26 15:58:43</p>
 *
 * @author swb
 */
public class Result {
    protected Boolean success ;
    protected String msg ;
    protected Integer code ;

    public Result() {
    }

    public Result(Boolean success,Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultCode resultCode) {
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.msg = resultCode.message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
