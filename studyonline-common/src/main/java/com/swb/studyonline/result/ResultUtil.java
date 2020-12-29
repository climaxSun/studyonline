package com.swb.studyonline.result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>文件  ResultUtil</p>
 * <p>时间  2020-12-26 16:43:55</p>
 *
 * @author swb
 */
public class ResultUtil {
    private static final Integer SUCCESS_CODE;
    private static final String SUCCESS_MESSAGE;
    private static final Integer ERROR_CODE;
    private static final String ERROR_MESSAGE;

    static {
        SUCCESS_CODE = ResultCode.SUCCESS.code;
        SUCCESS_MESSAGE = ResultCode.SUCCESS.message;
        ERROR_CODE = ResultCode.ERROR.code;
        ERROR_MESSAGE = ResultCode.ERROR.message;
    }

    public ResultUtil() {
    }

    public static Result successResult() {
        return new Result(true, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> SingleResult<T> successSingleResult(T t) {
        return new SingleResult<T>(t, ResultCode.SUCCESS);
    }

    public static <T> SingleResult<T> successSingleResult(T t, String message) {
        return new SingleResult<T>(t, message, SUCCESS_CODE, true);
    }

    public static <T> SingleResult<T> errorSingleResult(T t, String message) {
        return new SingleResult<T>(t, message, ERROR_CODE, false);
    }

    public static <T> SingleResult<T> errorSingleResult(T t) {
        return new SingleResult<T>(t, ResultCode.ERROR);
    }

    public static <T> SingleResult<T> errorSingleResult(String message) {
        return new SingleResult<T>(ERROR_CODE, message, false);
    }

    public static <T> SingleResult<T> errorSingleResult(Integer code,String message) {
        return new SingleResult<T>(code, message, false);
    }

    public static <T> SingleResult<T> createSingleResult(ResultCode code) {
        return new SingleResult<T>(code.code, code.message, code.success);
    }

    public static <T> ListResult<T> errorListResult(List<T> dataList, String message) {
        return new ListResult<T>(false, ERROR_CODE, message, dataList);
    }

    public static <T> ListResult<T> successListResult(List<T> dataList) {
        return new ListResult<T>(true, SUCCESS_CODE, SUCCESS_MESSAGE, dataList);
    }

    public static <T> ListResult<T> successListResult(List<T> dataList, Integer currentPage, Integer rows, Integer total) {
        return new ListResult<T>(true, SUCCESS_CODE, SUCCESS_MESSAGE, dataList, currentPage, rows, total);
    }


    public static void writeResponse(HttpServletResponse response, Boolean success, Integer code, String message) {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        try {
            response.getWriter().write("{\"success\":"+success+",\"msg\":\""+message+"\",\"code\":"+code+"}");
        } catch (IOException var4) {
            response.setStatus(500);
        }

    }

}
