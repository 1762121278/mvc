package com.dfgx.user.service;


import com.dfgx.user.entity.TUser;

import java.util.List;

public interface UserService {
    public List<TUser> select();
    public int insert(TUser user);
    public int update(Integer id);
    public int delete(Integer id);
}
