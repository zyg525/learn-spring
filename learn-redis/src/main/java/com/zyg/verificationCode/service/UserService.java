package com.zyg.verificationCode.service;

/**
 * @Author: zyg
 * @Date: 2023/5/9 8:42
 * @Version: v1.0
 * @Description:
 */
public interface UserService {
    String generateAuthCode(String phone);

    String getAuthCode(String phone);
}
