package com.swb.studyonline.result;

/**
 * <p>文件  SuccessResult</p>
 * <p>时间  2020-12-26 15:40:08</p>
 *
 * @author swb
 */
public class SingleResult<T> extends Result {
    private T data;

    public SingleResult() {
        this.success=true;
        this.code= ResultCode.SUCCESS.code;
        this.msg=ResultCode.SUCCESS.message;
    }

    public SingleResult(T data, ResultCode commonCode) {
        this.success=commonCode.success;
        this.code=commonCode.code;
        this.msg=commonCode.message;
        this.data = data;
    }

    public SingleResult(T data, String msg,Integer code,Boolean success) {
        this.success=success;
        this.code=code;
        this.msg=msg;
        this.data = data;
    }

    public SingleResult(ResultCode commonCode) {
        this.success=commonCode.success;
        this.code=commonCode.code;
        this.msg=commonCode.message;
    }

    public SingleResult(Integer code,String msg,Boolean success) {
        this.success=success;
        this.code=code;
        this.msg=msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
