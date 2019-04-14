package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>项目名称：springcloud
 * 类名称：PageController
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/13 11:25
 * 修改人：张利瑶
 * 修改时间：2019/4/13 11:25
 * 修改备注：
 * @version </pre>
 */
@Controller
public class PageController {

    //跳转前台页面
    @GetMapping("/page/easyui")
    public String easyui(){
        return  "main";
    }

    //跳转用户查询
    @GetMapping("/page/queryUser")
    public String queryUser(){
        return "user";
    }

    //跳转用户查询
    @GetMapping("/page/toAddShop")
    public String toAddShop(){
        return "toAddShop";
    }

    @GetMapping("/page/toUpdateUser")
    public String toUpdateUser(){
        return "toUpdateUser";
    }



}
