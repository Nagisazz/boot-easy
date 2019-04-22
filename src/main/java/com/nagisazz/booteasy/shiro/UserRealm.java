package com.nagisazz.booteasy.shiro;

import com.google.common.collect.Lists;
import com.nagisazz.booteasy.entity.User;
import com.nagisazz.booteasy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author NagisaZZ
 * @description: UserRealm
 * @date 2019/4/22  16:22
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //执行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //给资源授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (user.getPerms().contains(",")) {
            simpleAuthorizationInfo.addStringPermissions(Lists.newArrayList(user.getPerms().split(",")));
        } else {
            simpleAuthorizationInfo.addStringPermission(user.getPerms());
        }
        return simpleAuthorizationInfo;
    }

    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        //shiro判断逻辑
        UsernamePasswordToken user = (UsernamePasswordToken) arg0;
        User realUser = new User();
        realUser.setName(user.getUsername());
        realUser.setPassword(String.copyValueOf(user.getPassword()));
        User newUser = userService.findUserByNameAndPassword(realUser);
        //System.out.println(user.getUsername());
        if (newUser == null) {
            //用户名错误
            //shiro会抛出UnknownAccountException异常
            return null;
        }

        return new SimpleAuthenticationInfo(newUser, newUser.getPassword(), "");
    }
}
