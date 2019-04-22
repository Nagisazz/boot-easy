package com.nagisazz.booteasy.base.dao;

import com.nagisazz.booteasy.base.entity.BaseEntity;
import org.springframework.data.mybatis.repository.support.MybatisRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author NagisaZZ
 * @description: BaseDao
 * @date 2019/4/22  9:44
 */
@NoRepositoryBean
public interface BaseDao<PK extends Serializable, T extends BaseEntity<PK>> extends MybatisRepository<T, PK> {
}
