package com.dfgx.user.service;

import com.dfgx.user.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Today
 */
@Service
public interface StudentService {

    List<Student> selectByName();

    void printName();
}
