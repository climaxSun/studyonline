package com.swb.studyonline.aspect;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>文件  ControllerAspect</p>
 * <p>时间  2020-11-18 22:02:38</p>
 *
 * @author swb
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    public LogAspect(){
        log.debug("加载日志切面");
    }

    @Around("execution(public * com.swb.*..*controller..*.*(..)) || execution(public * com.swb.*.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        String url = null;
        String paramStr="";
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            url = request.getRequestURL().toString();
            if(StrUtil.equals(request.getMethod(),"POST")){
                List<Object> paramsList = Stream.of(args)
                        .filter(obj -> !(obj instanceof MultipartFile))
                        .filter(obj-> !(obj instanceof MultipartFile[]))
                        .collect(Collectors.toList());
                paramStr= JSONUtil.toJsonStr(paramsList);
            }else{
                paramStr= JSONUtil.toJsonStr(args);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PARAMETER_LOG#");
        sb.append(url);
        sb.append(paramStr);
        sb.append("#");
        long startTime = System.currentTimeMillis();
        Object resultObj = joinPoint.proceed(args);
        sb.append((int)(System.currentTimeMillis() - startTime));
        log.debug(sb.toString());
        return resultObj;
    }
}
