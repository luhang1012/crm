package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 15625 on 2020/1/22.
 */
@Controller
public class MainController extends BaseController{
    @RequestMapping("main")
    public String index(){
        return "main";
    }
}
