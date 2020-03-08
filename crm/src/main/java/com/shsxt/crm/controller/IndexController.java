package com.shsxt.crm.controller;

<<<<<<< HEAD
import com.shsxt.crm.base.BaseController;
=======
>>>>>>> f6ce3391221933bbaf5f13abf6f88ca4a4e5b78d
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 15625 on 2020/1/22.
 */
@Controller
<<<<<<< HEAD
public class IndexController extends BaseController{
    @RequestMapping("index")
    public String index(){
=======
public class IndexController {
    @RequestMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("ctx",request.getContextPath());   //当前项目路径
>>>>>>> f6ce3391221933bbaf5f13abf6f88ca4a4e5b78d
        return "index";
    }
}
