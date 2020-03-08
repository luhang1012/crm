package com.shsxt.crm.exceptions;

import com.alibaba.fastjson.JSON;
import com.shsxt.crm.model.ResultInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by 15625 on 2020/1/29.
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = createDefaultModelAndView(request, ex);
        /**
         * 写在最上面，不再区分页面还是Json
         */
        if (ex instanceof LoginException){
            LoginException e = (LoginException) ex;
            mv.setViewName("login_error");
            mv.addObject("errorMsg",e.getMsg());
            return mv;
        }
        //区分页面请求和错误请求（通过@ResponseBody注解区分）Object handler指代你请求过来的方法
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            ResponseBody annotation = method.getAnnotation(ResponseBody.class);
            if(null==annotation){
                if(ex instanceof ParamsException){
                    ParamsException e = (ParamsException) ex;
                    mv.setViewName("error");//可以单独设置
                    mv.addObject("errorMsg",e.getMsg());
                }
            }else {
                ResultInfo info = new ResultInfo();
                info.setCode(300);  //默认错误码
                info.setMsg("系统繁忙");   //默认错误信息
                if(ex instanceof ParamsException){
                    ParamsException e = (ParamsException) ex;
                    info.setCode(300);  //默认错误码
                    info.setMsg(e.getMsg());   //默认错误信息
                }
                /**
                 * 响应JSON到前台
                 */

                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");
                PrintWriter pw =null;

                try {
                    pw = response.getWriter();
                    pw.write(JSON.toJSONString(info));
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(null!=pw){
                        pw.close();
                    }
                }
                return null;
            }
        }
        return mv;
    }

    private ModelAndView createDefaultModelAndView(HttpServletRequest request,Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errorMsg",ex.getMessage());
        mv.addObject("ctx",request.getContextPath());   //上下文环境  /crm
        mv.addObject("uri",request.getRequestURI());    //请求路径  /main
        return mv;
    }
}