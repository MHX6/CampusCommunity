package com.htu.shareinfo.controller;

import com.htu.shareinfo.entity.Information;
import com.htu.shareinfo.entity.User;
import com.htu.shareinfo.service.InfoService;
import com.htu.shareinfo.service.PublishService;
import com.htu.shareinfo.util.ResponseMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private PublishService publishService;

    @Autowired
    private InfoService infoService;

    @RequestMapping("/publishPage")
    public ModelAndView publishPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/publish");
        return mav;
    }

    @RequestMapping("/publish/{id}")
    public ModelAndView esitPage(@PathVariable("id")Long id, Model model){
        ModelAndView mav = new ModelAndView();
        Information information = infoService.selectByid(id);
        model.addAttribute("id",id);
        model.addAttribute("title",information.getTitle());
        model.addAttribute("content",information.getContent());
        model.addAttribute("label",information.getLabel());
        mav.setViewName("/publish");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/publish")
    public Map<String,Object> publish(Information information, HttpServletRequest request ){
        User user = (User) request.getSession().getAttribute("userExist");
        Long uid = infoService.selectByid(information.getId()).getUid();
        if (user==null){
            return ResponseMapUtil.fail("请登录");
        }
        if (0 == information.getId()){
            if (information.getTitle()==null||information.getTitle().equals("")){
                return ResponseMapUtil.fail("标题不能为空");
            }
            if (information.getContent()==null||information.getContent().equals("")){
                return ResponseMapUtil.fail("内容不能为空");
            }
            if (information.getLabel()==null||information.getLabel().equals("")){
                return ResponseMapUtil.fail("标签不能为空");
            }
            Date date = new Date();
            information.setCreateTime(date);
            information.setUid(user.getUid());
            publishService.publishInfo(information);
        } else if (user.getUid() == uid){
            Date date = new Date();
            information.setCreateTime(date);
            publishService.updateInfo(information);
        }
        return ResponseMapUtil.success("添加成功");
    }




}
