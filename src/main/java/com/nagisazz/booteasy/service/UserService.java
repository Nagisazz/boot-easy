package com.nagisazz.booteasy.service;

import com.nagisazz.booteasy.base.exception.InfoCode;
import com.nagisazz.booteasy.base.exception.ServiceException;
import com.nagisazz.booteasy.base.vo.PageParam;
import com.nagisazz.booteasy.cache.annotation.RedisCache;
import com.nagisazz.booteasy.cache.annotation.RedisEvict;
import com.nagisazz.booteasy.dao.UserDao;
import com.nagisazz.booteasy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author NagisaZZ
 * @description: UserService
 * @date 2019/4/22  10:18
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @RedisCache(type = User.class)
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @RedisCache(type = User.class)
    public Page<User> selectNamePage(String name, PageParam pageParam) {
        return userDao.selectName(name, pageParam.createPageRequest());
    }

    @RedisEvict(type = User.class)
    public void insert(User user) {
        try {
            userDao.insert(user);
        } catch (Exception e) {
            throw new ServiceException(InfoCode.EMSG0001, e);
        }
    }
}
