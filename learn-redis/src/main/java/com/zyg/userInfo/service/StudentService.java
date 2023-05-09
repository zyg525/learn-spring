package com.zyg.userInfo.service;

import com.zyg.userInfo.entity.Student;

import java.util.List;

/**
 * @Author: zyg
 * @Date: 2023/5/9 9:53
 * @Version: v1.0
 * @Description:
 */
public interface StudentService {
    List<Student> selectStudent(Student student);

    Integer insertStudent(Student student);

    Integer updateStudentById(Student student);

    Integer deleteStudentByName(String name);
}
