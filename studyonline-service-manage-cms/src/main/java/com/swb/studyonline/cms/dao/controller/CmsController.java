package com.swb.studyonline.cms.dao.controller;

import com.swb.studyonline.api.cms.CmsPageControllerApi;
import com.swb.studyonline.cms.dao.service.CmsPageService;
import com.swb.studyonline.domain.cms.request.QueryPageRequest;
import com.swb.studyonline.model.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>文件  CmsController</p>
 * <p>时间  2020-11-18 19:50:49</p>
 *
 * @author swb
 */
@RestController
@RequestMapping("/cms")
public class CmsController implements CmsPageControllerApi {

    @Autowired
    private CmsPageService cmsPageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {
        return cmsPageService.findList(page,size,queryPageRequest);
    }
}
