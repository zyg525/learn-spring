package com.zyg.verificationCode.service.impl;

import com.zyg.common.service.RedisService;
import com.zyg.verificationCode.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: zyg
 * @Date: 2023/5/9 8:45
 * @Version: v1.0
 * @Description:
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.key.authCode}")
    private String REDIS_KEY_AUTH_CODE;

    @Value("${redis.expire.authCode}")
    private Long REDIS_EXPIRE_AUTH_CODE;

    @Autowired
    RedisService redisService;

    @Override
    public void setAuthCode(String phone, String authCode) {
        String key = REDIS_DATABASE+":"+REDIS_KEY_AUTH_CODE+":"+phone;
        redisService.set(key, authCode, REDIS_EXPIRE_AUTH_CODE);
    }

    @Override
    public String getAuthCode(String phone) {
        String key = REDIS_DATABASE+":"+REDIS_KEY_AUTH_CODE+":"+phone;
        String authCode = (String) redisService.get(key);
        return authCode;
    }
}
