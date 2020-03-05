package com.htu.shareinfo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.htu.shareinfo.dto.ArticleDTO;
import com.htu.shareinfo.dto.PaginationDTO;
import com.htu.shareinfo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView index(Model model,
                              @RequestParam(name = "page", defaultValue = "1") Integer page,
                              @RequestParam(name = "size", defaultValue = "2") Integer size,
                              @RequestParam(name = "search", required = false) String search,
                              @RequestParam(name = "tag", required = false) String tag,
                              @RequestParam(name = "sort", required = false) String sort){
        ModelAndView mav = new ModelAndView();
        PaginationDTO paginationDTO = articleService.selectAllArticle(page,size);
        model.addAttribute("paginationDTO",paginationDTO);
        mav.setViewName("index");
        return mav;
    }


}
