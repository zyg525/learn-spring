package com.zyg.common.service;

/**
 * @Author: zyg
 * @Date: 2023/5/9 8:56
 * @Version: v1.0
 * @Description:
 */
public interface RedisService {
    void set(String key, Object value, Long expire);

    Object get(String key);

    Boolean del(String key);
}
