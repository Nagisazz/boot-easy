package com.nagisazz.booteasy.cache.annotation;

import java.lang.annotation.*;

/**
 * @author NagisaZZ
 * @description: RedisCache注解
 * @date 2019/4/1  14:57
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {

    /**
     * redisKey
     * @return
     */
    Class type();
}
