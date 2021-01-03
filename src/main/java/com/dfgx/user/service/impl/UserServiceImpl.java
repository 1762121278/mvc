package com.dfgx.user.service.impl;

import com.dfgx.user.mapper.TUserMapper;
import com.dfgx.user.entity.TUser;
import com.dfgx.user.entity.TUserExample;
import com.dfgx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;
    /**
     * @return: java.util.List<com.dfgx.user.pojo.TUser>
     * @author: Today
     * @date: 2020/12/22 14:25
     * @description:查询所有
     */
    @Override
    public List<TUser> select() {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria().andIdEqualTo(8);
        TUser user = userMapper.selectByPrimaryKey(8);
        System.out.println(user);
        List<TUser> users = userMapper.selectByExample(example);
        System.out.println(users);
        return users;
    }

    /**
     * @param user:
     * @return: void
     * @author: Today
     * @date: 2020/12/22 15:50
     * @description:插入User对象到数据库
     */
    public int insert(TUser user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    /**
     * @param id:
     * @return: int
     * @author: Today
     * @date: 2020/12/22 16:50
     * @description:修改
     */
    public int update(Integer id){
        TUser user = new TUser();
        user.setId(id);
        user.setEmail("1762121@qq.com");
        user.setLoginacct("15256527568");
        user.setRealname("Sun");
        int i = userMapper.updateByPrimaryKey(user);
        return i;
    }

    /**
     * @param id:
     * @return: int
     * @author: Today
     * @date: 2020/12/22 16:52
     * @description:删除
     */
    public int delete(Integer id){
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria().andIdEqualTo(9);
        return userMapper.deleteByExample(example);
    }


}
