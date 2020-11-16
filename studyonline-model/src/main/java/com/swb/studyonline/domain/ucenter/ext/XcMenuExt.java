package com.swb.studyonline.domain.ucenter.ext;

import com.swb.studyonline.domain.course.ext.CategoryNode;
import com.swb.studyonline.domain.ucenter.XcMenu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@Data
@ToString
public class XcMenuExt extends XcMenu {

    List<CategoryNode> children;
}
