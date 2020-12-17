package com.swb.studyonline.cms.dao;

import com.swb.studyonline.cms.dao.dao.CmsPageRepository;
import com.swb.studyonline.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>文件  CmsPageTest</p>
 * <p>时间  2020-11-30 21:13:03</p>
 *
 * @author swb
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void testDataMongodbExample(){
        //分页
        Pageable page= PageRequest.of(0,10);
        //指定对象具体信息
        CmsPage obj=new CmsPage();
        obj.setSiteId("5a751fab6abb5044e0d19ea1");
        obj.setPageAliase("分类");
        ExampleMatcher matcher = ExampleMatcher.matching();
        matcher=matcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<CmsPage> example=Example.of(obj,matcher);
        Page<CmsPage> all = cmsPageRepository.findAll(example, page);
        System.out.println(all.getContent());
    }
}
