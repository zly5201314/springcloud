package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.TreeBean;
import com.jk.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>项目名称：springcloud
 * 类名称：UserserviceImpl
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/12 21:08
 * 修改人：张利瑶
 * 修改时间：2019/4/12 21:08
 * 修改备注：
 * @version </pre>
 */
@Controller
public class UserserviceImpl{

    @Autowired
    private UserMapper usermapper;


 /*   //查询
    @GetMapping("/queryUserList")
    @ResponseBody
    public List<UserBean>  queryUserList() {
        List<UserBean> list=usermapper.queryUserlist();
        return list;
    }*/


    //左侧树
    @GetMapping("/tree/findTree")
    @ResponseBody
    public List<TreeBean> findTree(){
        int pid=0;
        List<TreeBean> list = getTreeBeans(pid);
        return list;
    }

    private List<TreeBean> getTreeBeans(int pid) {
        List<TreeBean> list = usermapper.findTree(pid);
        for (TreeBean treeBean : list) {
            Integer id = treeBean.getId();
            List<TreeBean> nodes = getTreeBeans(id);
            if(nodes.size()<=0){
                //无子节点
                treeBean.setSelectable(true);
            }else{
                //有子节点
                treeBean.setSelectable(false);
                treeBean.setNodes(nodes);
            }
        }
        return list;
    }

    //新增
    @PostMapping("/user/saveUser")
    @ResponseBody
    public void saveUser(@RequestBody UserBean user){
        usermapper.saveUser(user);
    }


    //删除
    @DeleteMapping("/user/deleteAll")
    @ResponseBody
    public void deleteAll(@RequestParam("ids")  Integer[] ids){
        usermapper.deleteItem(ids);
    }

    //回显
    @GetMapping("/user/findUserById")
    @ResponseBody
    public UserBean findUserById(@RequestParam("shopId") Integer shopId){
          return usermapper.findUserById(shopId);
    }


    @PutMapping("/user/saveUser")
    @ResponseBody
    public void updateUser(@RequestBody UserBean user){
        usermapper.updateUser(user);
    };

    //查询
    @PostMapping("/user/queryUserList")
    @ResponseBody
    public HashMap<String, Object> queryUserList(@RequestParam(value = "page") Integer page,@RequestParam(value = "rows") Integer rows,@RequestBody UserBean user){
        HashMap<String, Object> hashMap = new HashMap<>();
        int count=usermapper.queryCount(user);
        int start=(page-1)*rows;
        List<UserBean> list=usermapper.queryUserList(start,rows,user);
        hashMap.put("total",count);
        hashMap.put("rows",list);
        return hashMap;
    };


}
