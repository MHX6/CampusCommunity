package com.htu.shareinfo.service.serviceImpl;

import com.htu.shareinfo.entity.User;
import com.htu.shareinfo.mapper.UserMapper;
import com.htu.shareinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mhx
 * @date 2020-02-13 11:21
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

}
