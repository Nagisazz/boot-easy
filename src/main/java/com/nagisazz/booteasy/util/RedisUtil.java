package com.nagisazz.booteasy.util;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author NagisaZZ
 * @description: ExceptionHandle
 * @date 2019/4/22  11:58
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 判断hashKey是否存在
     *
     * @param key
     * @param mapKey
     * @return
     */
    public boolean hasMapKey(String key, String mapKey) {
        return redisTemplate.opsForHash().hasKey(key, mapKey);
    }

    /**
     * 获取hashKey
     *
     * @param key
     * @param mapKey
     * @return
     */
    public Object getMapKey(String key, String mapKey) {
        return redisTemplate.opsForHash().get(key, mapKey);
    }

    /**
     * 删除hashKey
     *
     * @param key
     * @param mapKey
     * @return
     */
    public Object deleteMapKey(String key, String... mapKey) {
        return redisTemplate.opsForHash().delete(key, mapKey);
    }

    /**
     * 返回map的长度
     *
     * @param key
     * @return
     */
    public Long mapSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * 设置map
     *
     * @param key
     * @return
     */
    public void setMap(String key, String mapKey, String value) {
        redisTemplate.opsForHash().put(key, mapKey, value);
    }

    /**
     * 返回map中小于指定value的键集合
     *
     * @param key
     * @param date
     * @return java.util.List<java.lang.String>
     */
    public List<String> getExpireMapKeys(String key, Long date) {
        List<String> keys = Lists.newArrayList();
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(key, ScanOptions.NONE);
        while (cursor.hasNext()) {
            Map.Entry<Object, Object> entry = cursor.next();
            long value = (Long) entry.getValue();
            if (value < date) {
                keys.add((String) entry.getKey());
            }
        }
        return keys;
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @return
     */
    public void setExpire(String key, Long time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 删除指定key
     *
     * @param key
     * @return void
     */
    public void removeKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 判断是否存在指定Key
     *
     * @param key
     * @return java.lang.Boolean
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置string
     *
     * @param key
     * @param value
     * @return void
     */
    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @return java.lang.String
     */
    public String getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 自增后获取值
     */
    public Integer incrAndGet(String key) {
        return redisTemplate.opsForValue().increment(key, 1L).intValue();
    }

    /**
     * setSet结构
     *
     * @param key
     * @param value
     * @return void
     */
    public void setSet(String key, String... value) {
        redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 移除Set中的某个值
     *
     * @param key
     * @param value
     * @return void
     */
    public void removeSetValue(String key, Object value) {
        if (isMemberSet(key, value)) {
            redisTemplate.opsForSet().remove(key, value);
        }
    }

    /**
     * 判断是否是set中成员
     *
     * @param key
     * @param value
     * @return java.lang.Boolean
     */
    public Boolean isMemberSet(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }
}
