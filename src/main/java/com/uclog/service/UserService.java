package com.uclog.service;/**
 * Created by wangyu on 2017/8/9.
 */

import com.uclog.model.User;

import java.util.List;
import java.util.Set;

/** 用户Service
 * @author yu.wang15
 * @create 2017-08-09 13:41
 **/
public interface UserService {

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUser();

    /**
     * 获取用户角色
     * @param loginName
     * @return
     */
    Set<String> getRoles(String loginName);

    /**
     * 获取用户权限
     * @param loginName
     * @return
     */
    Set<String> getPermissions(String loginName);

    /**
     * 根据用户名获取用户对象
     * @param loginName
     * @return
     */
    User getByUsername(String loginName);
}
