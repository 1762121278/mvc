package com.dfgx.user.service.impl;

import com.dfgx.user.service.ReService;
import org.springframework.stereotype.Service;

@Service(value = "ReServiceImpl")
public class ReServiceImpl implements ReService {

    @Override
    public void name() {
        System.out.println("按照类型注入");
    }
}
