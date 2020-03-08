package com.shsxt.crm.interceptors;

import com.shsxt.crm.po.User;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 15625 on 2020/1/31.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 验证cookie中是否有ID，并且ID是否有效
         */
        Integer id = LoginUserUtil.releaseUserIdFromCookie(request);     //该方法已经把ID解密
        AssertUtil.isNotLogin(0==id || null == userService.queryUserById(id),"用户未登录");  //抛异常就走GlobalExceptionResolver去了，不会走到return true;
        return true;    //true代表往下走，false表示拦截
    }
}
