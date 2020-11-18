package com.swb.studyonline.model.response;

import lombok.Data;
import lombok.ToString;

/**
 * @author swb
 */
@Data
@ToString
public class QueryResponseResult extends ResponseResult {

    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
