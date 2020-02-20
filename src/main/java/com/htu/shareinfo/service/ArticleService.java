package com.htu.shareinfo.service;

import com.htu.shareinfo.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> selectAllArticle();
}
