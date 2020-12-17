package com.swb.studyonline.cms.dao.dao;

import com.swb.studyonline.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <p>文件  CmsPageRepository</p>
 * <p>时间  2020-11-29 15:47:48</p>
 *
 * @author swb
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {


    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);
}
