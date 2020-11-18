package com.swb.studyonline.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>文件  LoggerUtil</p>
 * <p>时间  2020-11-18 21:56:49</p>
 *
 * @author swb
 */
public class LoggerUtil {
    private static Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public LoggerUtil() {
    }

    public static String getMsg(String msg) {
        if (logger.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder();
            StackTraceElement targetStackTraceElement = (new Throwable()).getStackTrace()[3];
            sb.append(targetStackTraceElement.getClassName());
            sb.append(".");
            sb.append(targetStackTraceElement.getMethodName());
            sb.append("(");
            sb.append(targetStackTraceElement.getLineNumber());
            sb.append(")");
            sb.append("#");
            sb.append(msg);
            return sb.toString();
        } else {
            return msg;
        }
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(getMsg(message));
    }

    public static void debug(String message, Throwable throwable) {
        logger.debug(getMsg(message), throwable);
    }

    public static void warn(String message) {
        logger.warn(getMsg(message));
    }

    public static void warn(String message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    public static void error(String message) {
        logger.error(getMsg(message));
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

}
