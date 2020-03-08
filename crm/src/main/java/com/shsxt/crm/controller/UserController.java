package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.exceptions.ParamsException;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.model.UserInfo;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.CookieUtil;
import com.shsxt.crm.utils.UserIDBase64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 15625 on 2020/1/27.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{
    @Resource
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(String userName, String userPwd) {
        UserInfo userInfo = userService.login(userName, userPwd);
        return success(200,"登录成功",userInfo);
    }
    @RequestMapping("updateUserPwd")
    @ResponseBody
    public ResultInfo updateUserPwd(String oldPwd,String newPwd,String confirmPwd,HttpServletRequest request){
        //获取cookie中的ID
        String userIdStr = CookieUtil.getCookieValue(request, "userIdStr");
        //解密ID
        Integer id = UserIDBase64.decoderUserID(userIdStr);
        userService.updateUserPwd(oldPwd,newPwd,confirmPwd,id);
        return success(200,"修改成功");
    }
    @RequestMapping("queryCustomerManagers")
    @ResponseBody
    public List<Map> queryCustomerManagers(SaleChance saleChance, HttpServletRequest request){
        //获取cookie中的ID
        String userIdStr = CookieUtil.getCookieValue(request, "userIdStr");
        //解密ID
        Integer id = UserIDBase64.decoderUserID(userIdStr);
        List<Map> maps = userService.queryCustomerManagers();
        return maps;
    }
}
