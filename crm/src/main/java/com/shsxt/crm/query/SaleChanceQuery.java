package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 15625 on 2020/2/2.
 */
@Getter
@Setter
@ToString
public class SaleChanceQuery extends BaseQuery{
    //使用lombook，无需写get，set，toString
    private String customerName;
    private Integer state;
    private Integer devResult;
    private String createDate;
}
