package com.swb.studyonline.cms.dao.service;

import com.swb.studyonline.cms.dao.dao.CmsPageRepository;
import com.swb.studyonline.domain.cms.CmsPage;
import com.swb.studyonline.domain.cms.request.QueryPageRequest;
import com.swb.studyonline.domain.cms.response.CmsPageResult;
import com.swb.studyonline.model.response.CommonCode;
import com.swb.studyonline.model.response.QueryResponseResult;
import com.swb.studyonline.model.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p>文件  CmsPageService</p>
 * <p>时间  2020-11-29 15:56:06</p>
 *
 * @author swb
 */
@Service
public class CmsPageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    /**
     * 页面查询方法
     * @param page 页码，从1开始记数
     * @param size 每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){
        //分页参数
        if(page <=0){
            page = 1;
        }
        page = page -1;
        if(size<=0){
            size = 10;
        }
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    public CmsPageResult addCmsPage(CmsPage cmsPage) {
        CmsPage dbObj = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if(dbObj==null){
            cmsPage.setPageId(null);
            cmsPageRepository.save(cmsPage);
        }
        return new CmsPageResult(CommonCode.FAIL, null);
    }
}
