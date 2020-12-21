package com.dfgx.user.service.impl;

import com.dfgx.user.mapper.TUserMapper;
import com.dfgx.user.pojo.TUser;
import com.dfgx.user.pojo.TUserExample;
import com.dfgx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    public List<TUser> select() {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria().andIdEqualTo(8);
        TUser user = userMapper.selectByPrimaryKey(8);
        System.out.println(user);
        List<TUser> users = userMapper.selectByExample(example);
        System.out.println(users);
        return users;
    }




}
