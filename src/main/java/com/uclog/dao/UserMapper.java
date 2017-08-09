package com.uclog.dao;/**
 * Created by wangyu on 2017/8/9.
 */

import com.uclog.model.User;

import java.util.List;

/**
 * 用户
 *
 * @author yu.wang15
 * @create 2017-08-09 13:40
 **/

public interface UserMapper {
    List<User> getAllUser();
}
