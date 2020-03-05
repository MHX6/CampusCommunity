package com.htu.shareinfo.mapper;

import com.htu.shareinfo.entity.User;

public interface UserMapper {

    User login(User user);

    User findByUid(long uid);

}
