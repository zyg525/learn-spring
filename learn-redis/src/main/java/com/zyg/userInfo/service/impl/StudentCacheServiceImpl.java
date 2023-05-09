package com.zyg.userInfo.service.impl;

import com.zyg.common.service.RedisService;
import com.zyg.userInfo.entity.Student;
import com.zyg.userInfo.service.StudentCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zyg
 * @Date: 2023/5/9 10:33
 * @Version: v1.0
 * @Description:
 */
@Service
public class StudentCacheServiceImpl implements StudentCacheService {
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.key.userInfo}")
    private String REDIS_KEY_USER_INFO;

    @Value("${redis.expire.userInfo}")
    private Long REDIS_EXPIRE_USER_INFO;

    @Autowired
    RedisService redisService;

    @Override
    public List<Student> getStudent(String name) {
        String key = REDIS_DATABASE+":"+REDIS_KEY_USER_INFO+":"+name;
        List<Student> list = (List<Student>) redisService.get(key);
        return list;
    }

    @Override
    public void setStudent(String name, List<Student> list) {
        String key = REDIS_DATABASE+":"+REDIS_KEY_USER_INFO+":"+name;
        redisService.set(key,list,REDIS_EXPIRE_USER_INFO);
    }

    @Override
    public Boolean delStudent(String name) {
        String key = REDIS_DATABASE+":"+REDIS_KEY_USER_INFO+":"+name;
        return redisService.del(key);
    }
}
