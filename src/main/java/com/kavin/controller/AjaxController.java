package com.kavin.controller;

import com.kavin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {


    @Autowired
    private UserService userService;

    @RequestMapping("/oneCache")
    @ResponseBody
    public String query(){
        userService.oneCache();
        return "success";
    }


    @RequestMapping("/twoCache")
    @ResponseBody
    public String twoCache(){
        userService.twoCache();
        return "success";
    }


}
