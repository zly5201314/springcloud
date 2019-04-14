package com.jk.controller;

import com.jk.model.TreeBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>项目名称：springcloud
 * 类名称：TreeController
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/13 11:24
 * 修改人：张利瑶
 * 修改时间：2019/4/13 11:24
 * 修改备注：
 * @version </pre>
 */
@Controller
public class TreeController {

    @Autowired
    private UserService userservice;

    //左侧树
    @PostMapping("/tree/findTree")
    @ResponseBody
    public List<TreeBean> findTree(){
        List<TreeBean> list=userservice.findTree();
        return list;
    }
}
