package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.utils.CookieUtil;
import com.shsxt.crm.utils.UserIDBase64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 15625 on 2020/2/1.
 */
@Controller
@RequestMapping("saleChance")
public class SaleChanceController extends BaseController{
    @Resource
    private SaleChanceService saleChanceService;

    @RequestMapping("index")
    public String saleChance(){
        return "sale_chance";
    }

    /**
     * 查询用户
     */
    @RequestMapping("querySaleChancesByParams")
    @ResponseBody
    public Map<String, Object> queryByParams(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            SaleChanceQuery saleChanceQuery){
        saleChanceQuery.setPageNum(page);
        saleChanceQuery.setPageSize(rows);
        return saleChanceService.queryForPage(saleChanceQuery);
    }

    /**
     * 添加或更新
     */
    @RequestMapping("saveOrUpdateSaleChance")
    @ResponseBody
    public ResultInfo saveOrUpdateSaleChance(SaleChance saleChance, HttpServletRequest request){
        //获取cookie中的ID
        String userIdStr = CookieUtil.getCookieValue(request, "userIdStr");
        //解密ID
        Integer id = UserIDBase64.decoderUserID(userIdStr);
        saleChanceService.saveOrUpdateSaleChance(saleChance, id);
        return success("操作成功");
    }
}
