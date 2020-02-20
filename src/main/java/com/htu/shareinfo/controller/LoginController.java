package com.htu.shareinfo.controller;

import com.htu.shareinfo.entity.User;
import com.htu.shareinfo.service.UserService;
import com.htu.shareinfo.util.ResponseMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author mhx
 * @date 2020-02-05 16:17
 **/
@Controller
public class LoginController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/loginPage")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/loginPage");
        return mav;
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        ModelAndView mav = new ModelAndView();
        User userExist = userService.login(user);
        //System.out.println(userExist);
        session.setAttribute("userExist",userExist);
        if (userExist != null) {
            return "redirect:index";
        }
        return "loginPage";
    }

    @RequestMapping("/signout")
    public Map<String,Object> signout(HttpSession session){
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/loginPage");
      session.invalidate();
      return ResponseMapUtil.success("退出成功");
    }

}
