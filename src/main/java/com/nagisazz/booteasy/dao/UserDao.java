package com.nagisazz.booteasy.dao;

import com.nagisazz.booteasy.base.dao.BaseDao;
import com.nagisazz.booteasy.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mybatis.repository.annotation.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author NagisaZZ
 * @description: UserDao
 * @date 2019/4/22  10:05
 */
public interface UserDao extends BaseDao<Long, User> {

    User findByName(String name);

    @Query(operation = Query.Operation.page, namespace = "com.nagisazz.booteasy.entity.User", value = "selectByName")
    Page<User> selectName(@Param("name") String name, Pageable pageRequest);

}
