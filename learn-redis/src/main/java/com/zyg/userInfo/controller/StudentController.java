package com.zyg.userInfo.controller;

import com.zyg.userInfo.entity.Student;
import com.zyg.userInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zyg
 * @Date: 2023/5/9 9:56
 * @Version: v1.0
 * @Description:
 */
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/getStudent")
    public List<Student> getStudent(Student student) {
        long l1 = System.currentTimeMillis();
        List<Student> list = studentService.selectStudent(student);
        long l2 = System.currentTimeMillis();
        System.out.println("耗时:"+(l2-l1));
        return list;
    }

    @RequestMapping("/insertStudent")
    public Integer insertStudent(Student student) {
        return studentService.insertStudent(student);
    }

    @RequestMapping("/updateStudent")
    public Integer updateStudent(Student student) {
        return studentService.updateStudentById(student);
    }

    @RequestMapping("/deleteStudent")
    public Integer deleteStudent(Student student) {
        return studentService.deleteStudentByName(student.getName());
    }
}
