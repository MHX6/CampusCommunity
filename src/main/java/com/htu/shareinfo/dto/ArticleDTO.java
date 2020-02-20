package com.htu.shareinfo.dto;

import com.htu.shareinfo.entity.Article;
import com.htu.shareinfo.entity.User;

import java.util.Date;

/**
 * @author mhx
 * @date 2020-02-18 11:26
 **/
public class ArticleDTO extends Article {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
