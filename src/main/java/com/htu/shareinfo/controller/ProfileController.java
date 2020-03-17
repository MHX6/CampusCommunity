package com.htu.shareinfo.controller;

import com.htu.shareinfo.dto.PaginationDTO;
import com.htu.shareinfo.entity.User;
import com.htu.shareinfo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author mhx
 * @date 2020-03-15 01:20
 **/
@Controller
public class ProfileController {

    @Autowired(required = false)
    private InfoService infoService;

    @RequestMapping("/profile/{action}")
    public ModelAndView profile(@PathVariable(name = "action") String action,
                                @RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "size", defaultValue = "6") Integer size,
                                Model model,HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        User user = (User) session.getAttribute("userExist");
        PaginationDTO  paginationDTO = infoService.selectAllInfo(user.getUid(),page,size);
        model.addAttribute("paginationDTO",paginationDTO);
        mav.setViewName("/profile");
        return mav;
    }








}