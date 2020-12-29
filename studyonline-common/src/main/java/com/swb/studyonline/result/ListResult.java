package com.swb.studyonline.result;

import java.util.List;

/**
 * <p>文件  ListResult</p>
 * <p>时间  2020-12-26 16:31:35</p>
 *
 * @author swb
 */
public class ListResult<T> extends Result{
    private ListData<T> data;

    public ListResult() {
    }

    public ListResult(Boolean success,Integer code, String message) {
        super(success,code, message);
    }

    public ListResult(Boolean success,Integer code, String message, List<T> dataList) {
        super(success,code, message);
        this.data = new ListData<T>();
        this.data.setDataList(dataList);
        this.data.setCurrentPage(1);
        this.data.setTotalPage(1);
    }

    public ListResult(Boolean success,Integer code, String message, List<T> dataList, Integer currentPage, Integer rows, Integer total) {
        super(success,code, message);
        this.data = new ListData<T>();
        this.data.setDataList(dataList);
        if(null == currentPage) {
            currentPage = 1;
        }

        this.data.setCurrentPage(currentPage);
        this.data.setTotalPage(getTotalPage(rows, total));
        this.data.setTotalCount(total);
        this.data.setRows(rows);
    }

    public static int getTotalPage(Integer rows, Integer total) {
        if(null != rows && null != total && rows >= 1 && total >= 1 && rows < total) {
            int totalPage = total / rows;
            if(total % rows > 0) {
                ++totalPage;
            }
            return totalPage;
        } else {
            return 1;
        }
    }

    public ListData<T> getData() {
        return this.data;
    }

    public void setData(ListData<T> data) {
        this.data = data;
    }
}
