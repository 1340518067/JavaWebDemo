package com.westos.web01.service;

import com.westos.web01.bean.Student;

//学生操作相关接口
public interface StudentService {
    Student addStudent(Student student);
    Student findStudentByUsernameAndPassword(String username, String password);
}
