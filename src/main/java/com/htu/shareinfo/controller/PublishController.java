package com.htu.shareinfo.controller;

import com.htu.shareinfo.entity.Article;
import com.htu.shareinfo.service.PublishService;
import com.htu.shareinfo.util.ResponseMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author mhx
 * @date 2020-02-04 16:38
 **/
@Controller
public class PublishController {

    @Autowired(required = false)
    private PublishService publishService;

    @RequestMapping("/publishPage")
    public ModelAndView publishPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/publish");
        return mav;
    }

    @RequestMapping("/publish")
    public Map<String,Object> publish(Article article, HttpServletRequest request ){
        Integer id =(Integer) request.getSession().getAttribute("id");
        if (id==null){
            return ResponseMapUtil.fail("请登录");
        }
        Date date = new Date();
        article.setCreateTime(date);
        article.setUid(id);
        publishService.insertArticle(article);
        return ResponseMapUtil.success("添加成功");
    }




}
