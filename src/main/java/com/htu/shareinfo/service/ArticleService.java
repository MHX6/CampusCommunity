package com.htu.shareinfo.service;

import com.htu.shareinfo.dto.ArticleDTO;
import com.htu.shareinfo.dto.PaginationDTO;

import java.util.List;

public interface ArticleService {
    PaginationDTO selectAllArticle(Integer page, Integer size);

    Integer totalCount();
}
