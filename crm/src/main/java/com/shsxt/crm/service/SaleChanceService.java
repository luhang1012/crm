package com.shsxt.crm.service;

import com.shsxt.crm.base.BaseQuery;
import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.SaleChanceMapper;
import com.shsxt.crm.dao.UserMapper;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.po.User;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 15625 on 2020/2/2.
 */
@Service
public class SaleChanceService extends BaseService<SaleChance>{
    @Autowired
    private SaleChanceMapper saleChanceMapper;
    @Resource
    private UserMapper userMapper;
    public void saveOrUpdateSaleChance(SaleChance saleChance, Integer userId){
        //参数校验
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getCustomerName()),"客户名称为空");
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getLinkMan()),"联系人为空");
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getLinkPhone()),"电话号码为空");

        //通过id区分添加还是更新
        Integer id = saleChance.getId();
        saleChance.setUpdateDate(new Date());   //更新时间
        //是否制定分配人
        String linkMan = saleChance.getLinkMan();
        if(null!=linkMan && !"".equals(linkMan)){
            saleChance.setAssignTime(new Date());
            saleChance.setState(1);
        }else {
            saleChance.setState(0);
        }
        if(id==null){   //为null表示添加操作
            //通过ID查询创建人
            User user = userMapper.queryUserById(userId);
            //补全参数
            saleChance.setIsValid(1);   //有效
            saleChance.setCreateDate(new Date());   //创建时间
            saleChance.setCreateMan(user.getUserName());  //创建人
            saleChance.setDevResult(0); //默认未开发
            //执行操作
            AssertUtil.isTrue(saleChanceMapper.save(saleChance)<1, CrmConstant.OPS_FAILED_MSG);
        }else {     //更新
            //执行操作
            AssertUtil.isTrue(saleChanceMapper.update(saleChance)<1, CrmConstant.OPS_FAILED_MSG);
        }


    }
}
