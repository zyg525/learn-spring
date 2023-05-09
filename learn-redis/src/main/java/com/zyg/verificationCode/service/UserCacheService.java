package com.zyg.verificationCode.service;

/**
 * @Author: zyg
 * @Date: 2023/5/9 8:44
 * @Version: v1.0
 * @Description:
 */
public interface UserCacheService {
    void setAuthCode(String phone, String authCode);

    String getAuthCode(String phone);
}
