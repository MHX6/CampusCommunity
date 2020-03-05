package com.htu.shareinfo.service.serviceImpl;

import com.htu.shareinfo.dto.ArticleDTO;
import com.htu.shareinfo.dto.PaginationDTO;
import com.htu.shareinfo.entity.Article;
import com.htu.shareinfo.entity.User;
import com.htu.shareinfo.mapper.ArticleMapper;
import com.htu.shareinfo.mapper.UserMapper;
import com.htu.shareinfo.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mhx
 * @date 2020-02-18 10:45
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = false)
    private ArticleMapper articleMapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public PaginationDTO selectAllArticle(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = articleMapper.totalCount();
        paginationDTO.setPagination(totalCount,page,size);
        if (page < 1){
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page-1);
        List<Article> articleList = articleMapper.selectAllArticle(offset,size);
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        for (Article article : articleList){
            ArticleDTO articleDTO = new ArticleDTO();
            User user = userMapper.findByUid(article.getUid());
            BeanUtils.copyProperties(article,articleDTO);
            articleDTO.setUser(user);
            articleDTOList.add(articleDTO);
        }
        paginationDTO.setArticleDTOS(articleDTOList);
        return paginationDTO;
    }

    @Override
    public Integer totalCount() {
        return  articleMapper.totalCount();
    }
}
