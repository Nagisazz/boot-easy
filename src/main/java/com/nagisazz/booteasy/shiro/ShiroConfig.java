package com.nagisazz.booteasy.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NagisaZZ
 * @description: ShiroConfig
 * @date 2019/4/22  16:10
 */
@Configuration
public class ShiroConfig {

    //创建ShiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> fMap = new HashMap<String, String>();
        //拦截页面
        fMap.put("/findone", "authc");
        fMap.put("/findAll", "authc");
        fMap.put("/insert", "authc");

        //拦截未授权
        fMap.put("/findone", "perms[user:find]");
        fMap.put("/findAll", "perms[user:find]");
        fMap.put("/insert", "perms[user:create]");
        //被拦截返回登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //授权拦截返回页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/permission");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fMap);
        return shiroFilterFactoryBean;

    }

    @Bean(name = "defaultWebSecurityManager")
    //创建DefaultWebSecurityManager
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;

    }

    //创建Realm
    @Bean(name = "userRealm")
    public UserRealm getUserRealm() {
        return new UserRealm();
    }
}
