package com.htu.shareinfo.controller;

import com.htu.shareinfo.dto.ArticleDTO;
import com.htu.shareinfo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author mhx
 * @date 2020-01-23 22:20
 **/
@Controller
public class IndexController {

    @Autowired(required = false)
    private ArticleService articleService;

    @RequestMapping("/")
    public ModelAndView index(Model model){
        ModelAndView mav = new ModelAndView();
        List<ArticleDTO> articleDTOList = articleService.selectAllArticle();
        model.addAttribute("articleDTOList",articleDTOList);
        mav.setViewName("index");
        return mav;
    }




}
