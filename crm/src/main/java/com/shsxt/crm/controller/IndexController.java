package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 15625 on 2020/1/22.
 */
@Controller
public class IndexController extends BaseController{
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
