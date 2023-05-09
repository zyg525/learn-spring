package com.zyg.verificationCode.service.impl;

import com.zyg.verificationCode.service.UserCacheService;
import com.zyg.verificationCode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author: zyg
 * @Date: 2023/5/9 8:43
 * @Version: v1.0
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserCacheService userCacheService;

    @Override
    public String generateAuthCode(String phone) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<6;i++) {
            stringBuilder.append(random.nextInt(10));
        }
        userCacheService.setAuthCode(phone, stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    public String getAuthCode(String phone) {
        return userCacheService.getAuthCode(phone);
    }
}
