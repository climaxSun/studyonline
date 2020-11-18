package com.swb.studyonline.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>文件  CmsApplication</p>
 * <p>时间  2020-11-17 20:24:46</p>
 *
 * @author swb
 */
@SpringBootApplication(scanBasePackages = "com.swb.studyonline")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
