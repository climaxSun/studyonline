package com.swb.studyonline.model.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: swb.
 */
@Data
@ToString
public class QueryResult<T> {
    /**
     * 数据list
     */
    private List<T> list;
    /**
     * 数据总数
     */
    private Long total;

    /**
     * 页码
     */
    private Long page;

    /**
     * 页数
     */
    private Long size;
}
