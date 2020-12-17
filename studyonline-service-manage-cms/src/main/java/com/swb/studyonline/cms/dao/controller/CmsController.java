package com.swb.studyonline.cms.dao.controller;

import com.swb.studyonline.api.cms.CmsPageControllerApi;
import com.swb.studyonline.cms.dao.service.CmsPageService;
import com.swb.studyonline.domain.cms.CmsPage;
import com.swb.studyonline.domain.cms.request.QueryPageRequest;
import com.swb.studyonline.domain.cms.response.CmsPageResult;
import com.swb.studyonline.model.response.QueryResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    @ApiOperation("/新增一个页面")
    public CmsPageResult addCmsPage(@RequestBody CmsPage cmsPage){
        return cmsPageService.addCmsPage(cmsPage);
    }
}
