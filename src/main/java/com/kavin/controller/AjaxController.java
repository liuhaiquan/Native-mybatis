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

    @RequestMapping("/query")
    @ResponseBody
    public String query(){
        userService.getUserByUserCode();
        return "success";
    }


}
