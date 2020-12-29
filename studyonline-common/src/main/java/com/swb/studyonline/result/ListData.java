package com.swb.studyonline.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * <p>文件  ListData</p>
 * <p>时间  2020-12-26 16:27:58</p>
 *
 * @author swb
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListData<T> {
    private List<T> dataList;
    private Integer currentPage;
    private Integer totalPage;
    private Integer totalCount;
    private Integer rows;

    public ListData() {
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
