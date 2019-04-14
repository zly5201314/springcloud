package com.jk.mapper;

import com.jk.model.TreeBean;
import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <pre>项目名称：springcloud
 * 类名称：UserMapper
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/12 21:27
 * 修改人：张利瑶
 * 修改时间：2019/4/12 21:27
 * 修改备注：
 * @version </pre>
 */
public interface UserMapper {

  /*  //查询
    //@Select(value = "select * from t_user")
    List<UserBean> queryUserlist();*/

    //左侧树
    @Select(value = " select * from t_tree3 where pid=#{value} ")
    List<TreeBean> findTree(int pid);

    //新增
    void saveUser(@RequestBody UserBean user);

    //删除
    void deleteItem(@RequestParam("ids") Integer[] ids);

    //回显
    @Select(value = " select * from t_usera where id=#{value}")
    UserBean findUserById(@RequestParam("shopId") Integer shopId);

    //修改
    void updateUser(@RequestBody UserBean user);

    //总条数
    int queryCount(@Param("user") UserBean user);

    //分页查询
    List<UserBean> queryUserList(@Param("start") int start,@Param("rows")Integer rows,@Param("user")UserBean user);
}
