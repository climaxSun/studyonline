package com.swb.studyonline.domain.order.response;

import com.swb.studyonline.domain.order.XcOrders;
import com.swb.studyonline.model.response.ResponseResult;
import com.swb.studyonline.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/26.
 */
@Data
@ToString
public class OrderResult extends ResponseResult {
    private XcOrders xcOrders;
    public OrderResult(ResultCode resultCode, XcOrders xcOrders) {
        super(resultCode);
        this.xcOrders = xcOrders;
    }


}
