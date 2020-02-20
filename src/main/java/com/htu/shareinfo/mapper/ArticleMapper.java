package com.htu.shareinfo.mapper;

import com.htu.shareinfo.dto.ArticleDTO;
import com.htu.shareinfo.entity.Article;

import java.util.List;

public interface ArticleMapper {

    List<Article> selectAllArticle();

    Integer totalCount();
}
