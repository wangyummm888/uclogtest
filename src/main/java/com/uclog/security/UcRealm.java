package com.uclog.security;/**
 * Created by wangyu on 2017/8/9.
 */

import com.uclog.model.User;
import com.uclog.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import javax.annotation.Resource;


/**
 * @author yu.wang15
 * @create 2017-08-09 15:42
 **/
public class UcRealm extends AuthorizingRealm
{
    @Resource
    UserService userService;

    // 为当前登陆成功的用户授予权限和角色，已经登陆成功了
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal(); //获取用户名
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.getRoles(username));
        authorizationInfo.setStringPermissions(userService.getPermissions(username));
        return authorizationInfo;
    }

    // 验证当前用户
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); // 获取用户名
        User user = userService.getByUsername(username);
        if(user != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo
                    (user.getLoginName(), user.getPassWord(), "ucRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
