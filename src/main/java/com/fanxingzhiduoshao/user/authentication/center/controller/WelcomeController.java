package com.fanxingzhiduoshao.user.authentication.center.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author WangWenyu 2018/04/25
 */
@Controller
@Api(description = "欢迎页")
public class WelcomeController {

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public String home() {
        System.out.println("Welcome to user center!");
        return "welcome";
    }

}
