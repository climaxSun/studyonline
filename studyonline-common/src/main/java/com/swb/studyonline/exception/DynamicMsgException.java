package com.swb.studyonline.exception;

/**
 * <p>文件  TestException</p>
 * <p>时间  2020-12-03 19:11:17</p>
 *
 * @author swb
 */
public class DynamicMsgException extends  RuntimeException{
    public DynamicMsgException(String message) {
        super(message);
    }
}
