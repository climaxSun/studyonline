package com.swb.studyonline.domain.cms.response;

import com.swb.studyonline.model.response.ResponseResult;
import com.swb.studyonline.model.response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class GenerateHtmlResult extends ResponseResult {
    String html;
    public GenerateHtmlResult(ResultCode resultCode, String html) {
        super(resultCode);
        this.html = html;
    }
}
