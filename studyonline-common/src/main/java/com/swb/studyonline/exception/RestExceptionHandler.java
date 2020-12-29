package com.swb.studyonline.exception;

import com.swb.studyonline.result.Result;
import com.swb.studyonline.result.ResultCode;
import com.swb.studyonline.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>文件  DynamicMsgExceptionHandler</p>
 * <p>时间  2020-12-03 19:10:53</p>
 *
 * @author swb
 */
@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    public RestExceptionHandler() {
    }

    @ExceptionHandler({DynamicMsgException.class})
    public Result handle(DynamicMsgException e) {
        return ResultUtil.errorSingleResult(ResultCode.DYNAMIC_MSG.code(),e.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public Result handle(RuntimeException e) {
        log.error(e.getMessage(), e);
        ResultCode code = ExceptionFactory.getCode(e);
        return ResultUtil.createSingleResult(code);
    }
}
