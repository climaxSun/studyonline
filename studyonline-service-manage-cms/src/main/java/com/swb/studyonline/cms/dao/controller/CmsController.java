package com.swb.studyonline.cms.dao.controller;

import com.swb.studyonline.api.cms.CmsPageControllerApi;
import com.swb.studyonline.cms.dao.service.CmsPageService;
import com.swb.studyonline.domain.cms.CmsPage;
import com.swb.studyonline.domain.cms.request.QueryPageRequest;
import com.swb.studyonline.domain.cms.response.CmsPageResult;
import com.swb.studyonline.exception.DynamicMsgException;
import com.swb.studyonline.exception.RedisException;
import com.swb.studyonline.exception.UserException;
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

    @PostMapping("/")
    @ApiOperation("/新增一个页面")
    public CmsPageResult addCmsPage(@RequestBody CmsPage cmsPage){
        return cmsPageService.addCmsPage(cmsPage);
    }

    @PutMapping("/")
    public CmsPageResult updateCmsPage(@RequestBody CmsPage cmsPage){
        return cmsPageService.updateCmsPage(cmsPage);
    }

    @GetMapping("/load/{id}")
    public CmsPageResult getCmsPage(@PathVariable("id")String id){
        return cmsPageService.findById(id);
    }

    @DeleteMapping("/{id}")
    public CmsPageResult delete(@PathVariable("id") String id){
        return cmsPageService.deleteById(id);
    }

    @GetMapping("/test")
    public void testException(){
        throw new UserException(UserException.Type.USER_NOT_LOGIN,"用户XX未登录");
    }

    @GetMapping("/testDy")
    public void testDyException(){
        throw new DynamicMsgException("动态错误消息");
    }

    @GetMapping("/testOther")
    public void testOtherException(){
        throw new RedisException();
    }

}
