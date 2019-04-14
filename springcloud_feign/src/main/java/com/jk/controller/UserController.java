package com.jk.controller;

import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <pre>项目名称：springcloud
 * 类名称：UserController
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/12 21:12
 * 修改人：张利瑶
 * 修改时间：2019/4/12 21:12
 * 修改备注：
 * @version </pre>
 */
@RestController
public class UserController {

    @Autowired
    private UserService userservice;

  //查询
    @GetMapping("/user/queryUserList")
    public HashMap<String,Object> queryUserList(Integer page,Integer rows,UserBean user){
        HashMap<String,Object> has=userservice.queryUserList(page,rows,user);
        return has;
    }

    //新增
    @RequestMapping(value="/user/saveUser",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public void saveUser(UserBean user){
        if (user.getId()==null) {
            userservice.saveUser(user);
        } else {
            userservice.updateUser(user);
        }
    }

    //删除
    @GetMapping("/user/deleteAll")
    public Boolean deleteAll(@RequestParam("ids") Integer[] ids){
        try {
            userservice.deleteItem(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //回显
    @PostMapping("/user/findUserById")
    public UserBean findUserById(@RequestParam("shopId") Integer shopId){
        UserBean user=userservice.findUserById(shopId);
        return user;
    }


}
