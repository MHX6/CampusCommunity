package com.htu.shareinfo.service.serviceImpl;

import com.htu.shareinfo.entity.Article;
import com.htu.shareinfo.mapper.PublishMapper;
import com.htu.shareinfo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mhx
 * @date 2020-02-05 19:11
 **/
@Service
public class PublishServiceImpl implements PublishService {

    @Autowired(required = false)
    private PublishMapper publishMapper;

    @Override
    public void insertArticle(Article article) {
        publishMapper.insertArticle(article);
    }
}
