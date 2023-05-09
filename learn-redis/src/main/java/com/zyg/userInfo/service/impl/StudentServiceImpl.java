package com.zyg.userInfo.service.impl;

import com.zyg.userInfo.dao.StudentMapper;
import com.zyg.userInfo.entity.Student;
import com.zyg.userInfo.service.StudentCacheService;
import com.zyg.userInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zyg
 * @Date: 2023/5/9 9:54
 * @Version: v1.0
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentCacheService studentCacheService;

    @Override
    public List<Student> selectStudent(Student student) {
        List<Student> stu = studentCacheService.getStudent(student.getName());
        if(stu != null) {
            return stu;
        }
        List<Student> list = studentMapper.selectStudent(student);
        if(list != null) {
            studentCacheService.setStudent(list.get(0).getName(),list);
        }
        return list;
    }

    @Override
    public Integer insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public Integer updateStudentById(Student student) {
        Integer res = studentMapper.updateStudentById(student);
        studentCacheService.delStudent(student.getName());
        return res;
    }

    @Override
    public Integer deleteStudentByName(String name) {
        Integer res = studentMapper.deleteStudentByName(name);
        studentCacheService.delStudent(name);
        return res;
    }
}
