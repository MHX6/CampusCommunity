package com.htu.shareinfo.controller;

import com.htu.shareinfo.dto.InfoDTO;
import com.htu.shareinfo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author mhx
 * @date 2020-03-15 03:31
 **/
@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/info/{id}")
    public String info(@PathVariable("id")Long id, Model model){
        InfoDTO infoDTO = infoService.selectByid(id);
        model.addAttribute("infoDto",infoDTO);
        return "info";
    }

}
