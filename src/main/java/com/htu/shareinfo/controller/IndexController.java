package com.htu.shareinfo.controller;


import com.htu.shareinfo.dto.PaginationDTO;
import com.htu.shareinfo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mhx
 * @date 2020-01-23 22:20
 **/
@Controller
public class IndexController {

    @Autowired(required = false)
    private InfoService infoService;

    @RequestMapping("/")
    public ModelAndView index(Model model,
                              @RequestParam(name = "page", defaultValue = "1") Integer page,
                              @RequestParam(name = "size", defaultValue = "6") Integer size,
                              @RequestParam(name = "search", required = false) String search,
                              @RequestParam(name = "tag", required = false) String tag,
                              @RequestParam(name = "sort", required = false) String sort){
        ModelAndView mav = new ModelAndView();
        PaginationDTO paginationDTO = infoService.selectAllInfo(null,page,size);
        model.addAttribute("paginationDTO",paginationDTO);
        mav.setViewName("index");
        return mav;
    }


}
