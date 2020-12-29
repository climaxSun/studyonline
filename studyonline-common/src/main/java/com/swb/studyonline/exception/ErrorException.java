package com.swb.studyonline.exception;

/**
 * <p>文件  ErrorException</p>
 * <p>时间  2020-12-26 20:46:54</p>
 *
 * @author swb
 */
public abstract class ErrorException extends RuntimeException{
    public ErrorException(String msg){
        super(msg);
    }
}
