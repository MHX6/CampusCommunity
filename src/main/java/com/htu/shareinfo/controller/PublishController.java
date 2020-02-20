package com.htu.shareinfo.controller;

import com.htu.shareinfo.entity.Article;
import com.htu.shareinfo.entity.User;
import com.htu.shareinfo.service.PublishService;
import com.htu.shareinfo.util.ResponseMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseBody
    @RequestMapping("/publish")
    public Map<String,Object> publish(Article article, HttpServletRequest request ){
        User user = (User) request.getSession().getAttribute("userExist");
        if (user==null){
            return ResponseMapUtil.fail("请登录");
        }
        if (article.getTitle()==null||article.getTitle().equals("")){
            return ResponseMapUtil.fail("标题不能为空");
        }
        if (article.getContent()==null||article.getContent().equals("")){
            return ResponseMapUtil.fail("内容不能为空");
        }
        if (article.getLabel()==null||article.getLabel().equals("")){
            return ResponseMapUtil.fail("标签不能为空");
        }
        Date date = new Date();
        article.setCreateTime(date);
        article.setUid(user.getUid());
        publishService.insertArticle(article);
        return ResponseMapUtil.success("添加成功");
    }




}
