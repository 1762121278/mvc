package com.dfgx.user.mapper;

import com.dfgx.user.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    void insertList(List<Student> list);
}
