package com.swb.studyonline.utils;

import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>文件  ServletUtil</p>
 * <p>时间  2020-11-18 22:15:37</p>
 *
 * @author swb
 */
public class ServletUtil {
    private static final String NO_IP_ADDRESS = "unknown";
    private static final String USER_ID_KEY = "userid";
    private static final String USERNAME_KEY = "username";
    private static final String USER_TYPE_KEY = "usertype";
    private static final String NAME_KEY = "name";
    private static final String DEPT_KEY = "grpno";
    private static final String DEPT_NAME = "grpname";
    private static final String DEPT_RANK_KEY = "grprank";
    private static final String ROLE_RANK_KEY = "rolerank";
    private static final String CITY_ID = "cityId";

    private ServletUtil() {
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static void outPrint(HttpServletResponse response, Object vo) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write(JSONUtil.toJsonStr(vo));
            printWriter.flush();
            printWriter.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }
}
