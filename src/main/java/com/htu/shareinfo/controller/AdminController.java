package com.htu.shareinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mhx
 * @date 2020-03-05 15:46
 **/
@RequestMapping("/admin")
@Controller
public class AdminController {


    @RequestMapping("/index")
    public ModelAndView adminIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/index");
        return mav;
    }

}
