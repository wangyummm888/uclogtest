package com.uclog.service.impl;/**
 * Created by wangyu on 2017/8/9.
 */

import com.uclog.dao.UserMapper;
import com.uclog.model.User;
import com.uclog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

/**
 * @author yu.wang15
 * @create 2017-08-09 13:42
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserMapper userMapper;




    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public Set<String> getRoles(String loginName) {
        return null;
    }

    @Override
    public Set<String> getPermissions(String loginName) {
        return null;
    }

    @Override
    public User getByUsername(String loginName) {
        return null;
    }
}
