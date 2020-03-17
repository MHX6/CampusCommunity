package com.htu.shareinfo.dto;

import com.htu.shareinfo.entity.Information;
import com.htu.shareinfo.entity.User;

/**
 * @author mhx
 * @date 2020-02-18 11:26
 **/
public class InfoDTO extends Information {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
