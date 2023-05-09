package com.zyg.verificationCode.controller;

import com.zyg.verificationCode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyg
 * @Date: 2023/5/9 8:39
 * @Version: v1.0
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getAuthCode")
    public String getAuthCode(String phone) {
        String authCode = userService.generateAuthCode(phone);
        return authCode;
    }

    @RequestMapping("/verifyAuthCode")
    public String verifyAuthCode(String phone, String authCode) {
        String realAuthCode = userService.getAuthCode(phone);
        if(realAuthCode.equals(authCode)) {
            return "验证成功";
        }else {
            return "验证失败";
        }
    }
}
