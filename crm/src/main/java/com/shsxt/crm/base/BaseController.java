package com.shsxt.crm.base;

import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.model.UserInfo;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 15625 on 2020/1/30.
 */
public class BaseController {
    //该注解是先执行的标志
    @ModelAttribute
    public void preMethod(HttpServletRequest request){
        request.setAttribute("ctx",request.getContextPath());   //当前项目路径
    }

    public ResultInfo success(Integer code,String msg){
        ResultInfo info = new ResultInfo();
        info.setCode(code);
        info.setMsg(msg);
        return info;
    }
    public ResultInfo success(String msg){
        ResultInfo info = new ResultInfo();
        info.setMsg(msg);
        return info;
    }
    public ResultInfo success(String msg,Object obj){
        ResultInfo info = new ResultInfo();
        info.setMsg(msg);
        info.setObj(obj);
        return info;
    }
    public ResultInfo success(Integer code,String msg,Object obj){
        ResultInfo info = new ResultInfo();
        info.setCode(code);
        info.setMsg(msg);
        info.setObj(obj);
        return info;
    }
}
