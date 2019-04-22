package com.nagisazz.booteasy.base.entity;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * @author NagisaZZ
 * @description: BaseEntity
 * @date 2019/4/22  9:41
 */
public interface BaseEntity<PK extends Serializable> extends Persistable<PK> {
}
