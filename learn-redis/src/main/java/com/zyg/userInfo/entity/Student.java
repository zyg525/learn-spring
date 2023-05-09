package com.zyg.userInfo.entity;

import lombok.Data;

/**
 * @Author: zyg
 * @Date: 2023/5/9 9:36
 * @Version: v1.0
 * @Description:
 */
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Double score;
}
