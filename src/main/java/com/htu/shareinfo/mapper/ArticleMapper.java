package com.htu.shareinfo.mapper;

import com.htu.shareinfo.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {

    List<Article> selectAllArticle(@Param("offset")Integer offset, @Param("size")Integer size);

    Integer totalCount();
}
