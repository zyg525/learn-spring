package com.zyg.userInfo.service;

import com.zyg.userInfo.entity.Student;

import java.util.List;

/**
 * @Author: zyg
 * @Date: 2023/5/9 10:29
 * @Version: v1.0
 * @Description:
 */
public interface StudentCacheService {
    List<Student> getStudent(String name);

    void setStudent(String name, List<Student> list);

    Boolean delStudent(String name);
}
