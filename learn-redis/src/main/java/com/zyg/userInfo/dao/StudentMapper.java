package com.zyg.userInfo.dao;

import com.zyg.userInfo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zyg
 * @Date: 2023/5/9 9:34
 * @Version: v1.0
 * @Description:
 */
@Mapper
public interface StudentMapper {
    List<Student> selectStudent(Student student);

    Integer insertStudent(Student student);

    Integer updateStudentById(Student student);

    Integer deleteStudentByName(String name);
}
