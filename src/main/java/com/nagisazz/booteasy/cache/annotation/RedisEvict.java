package com.nagisazz.booteasy.cache.annotation;

import java.lang.annotation.*;

/**
 * @author NagisaZZ
 * @description: RedisEvict注解
 * @date 2019/4/1  16:16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisEvict {

    /**
     * redisKey
     * @param
     * @return  java.lang.Class
     */
    Class type();

    /**
     * methodName
     * @param
     * @return  java.lang.String
     */
    String methodName() default "";

    /**
     * parameterName
     * @param
     * @return  java.lang.String
     */
    String parameterName() default "";
}
