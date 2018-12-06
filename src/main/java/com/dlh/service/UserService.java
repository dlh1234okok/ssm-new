package com.dlh.service;

import com.dlh.base.BaseService;
import com.dlh.dao.UserMapper;
import com.dlh.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

}
