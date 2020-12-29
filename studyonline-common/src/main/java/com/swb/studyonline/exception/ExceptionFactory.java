package com.swb.studyonline.exception;

import com.swb.studyonline.result.ResultCode;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>文件  ExceptionFactory</p>
 * <p>时间  2020-12-26 20:48:54</p>
 *
 * @author swb
 */
public class ExceptionFactory {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionFactory.class);
    private static Map<Object, ResultCode> exceptionMap = new HashMap<>();

    static {
        exceptionMap.put(UserException.Type.USER_NOT_LOGIN, ResultCode.NO_LOGIN);
        exceptionMap.put(RedisException.class, ResultCode.REDIS_ERROR);
    }

    private static Object getType(Throwable throwable) {
        try {
            return FieldUtils.readDeclaredField(throwable, "type", true);
        } catch (Exception e) {
            return null;
        }
    }


    public static ResultCode getCode(Throwable throwable) {
        if (throwable == null) {
            return ResultCode.ERROR;
        }
        ResultCode restCode;
        if (throwable instanceof ErrorException) {
            Object type = getType(throwable);
            if (type != null) {
                restCode = exceptionMap.get(type);
                if (restCode != null) {
                    return restCode;
                }
            }
        }
        restCode = exceptionMap.get(throwable.getClass());
        if (restCode != null) {
            return restCode;
        }
        return ResultCode.ERROR;
    }
}
