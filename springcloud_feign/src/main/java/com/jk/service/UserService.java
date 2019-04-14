package com.jk.service;

import com.jk.model.TreeBean;
import com.jk.model.UserBean;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <pre>项目名称：springcloud
 * 类名称：UserService
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/12 21:13
 * 修改人：张利瑶
 * 修改时间：2019/4/12 21:13
 * 修改备注：
 * @version </pre>
 */
@FeignClient(value = "SERVICE-PROVIDER" )
public interface UserService {

    /*@GetMapping("/queryUserList")
    List<UserBean>  queryUserList();*/

    //左侧树
    @GetMapping("/tree/findTree")
    List<TreeBean> findTree();

    //新增
    @PostMapping("/user/saveUser")
    void saveUser(@RequestBody UserBean user);

    //删除
    @DeleteMapping("/user/deleteAll")
    void deleteItem(@RequestParam("ids") Integer[] ids);

    //回显
    @GetMapping("/user/findUserById")
    UserBean findUserById(@RequestParam("shopId") Integer shopId);

    //修改
    @PutMapping("/user/saveUser")
    void updateUser(@RequestBody UserBean user);

    @PostMapping("/user/queryUserList")
    HashMap<String, Object> queryUserList(@RequestParam(value = "page") Integer page,@RequestParam(value = "rows") Integer rows,@RequestBody UserBean user);
}
