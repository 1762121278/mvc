package com.dfgx.user.mapper;

import com.dfgx.user.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OriginMybatis implements StudentMapper{
    @Override
    public void insertList(List<Student> list) throws IOException {
        //mybatis的原理
        InputStream in = Resources.getResourceAsStream("mybatis/mybatis.config");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String sql = "update student set a = 1 where id =2 ";
        sqlSession.update(sql);
        sqlSession.close();
    }

    @Override
    public List<Student> selectByName() {
        return null;
    }
}
