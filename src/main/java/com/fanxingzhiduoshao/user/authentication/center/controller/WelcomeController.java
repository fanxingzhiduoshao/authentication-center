package com.fanxingzhiduoshao.user.authentication.center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String home(){
        System.out.println("Welcome to user center!");
        return "welcome";
    }

}
