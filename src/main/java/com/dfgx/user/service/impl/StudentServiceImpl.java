package com.dfgx.user.service.impl;

import com.dfgx.user.entity.Student;
import com.dfgx.user.mapper.StudentMapper;
import com.dfgx.user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectByName() {
        return studentMapper.selectByName();
    }

    @Override
    public void printName() {
        System.out.println("pringtName");
    }
}
