package com.swb.studyonline.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * <p>文件  CmsController</p>
 * <p>时间  2020-11-18 19:50:49</p>
 *
 * @author swb
 */
@RestController
public class CmsController {

    @GetMapping("/test")
    public String get(String s,String a){
        return "test";
    }

    @PostMapping("/test")
    public String post(@RequestBody Map map){
        return "test";
    }

    @PostMapping("/upload")
    public String post(MultipartFile file,String s,String a){
        return "test";
    }


    @PostMapping("/upload2")
    public String post(MultipartFile[] file,String s,String a){
        return "test";
    }

}
